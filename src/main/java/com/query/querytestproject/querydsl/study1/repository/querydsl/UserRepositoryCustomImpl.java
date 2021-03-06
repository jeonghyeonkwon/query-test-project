package com.query.querytestproject.querydsl.study1.repository.querydsl;

import com.query.querytestproject.querydsl.study1.dto.Study1PageUserDto;
import com.query.querytestproject.querydsl.study1.dto.Study1UserStaticValueDto;
import com.query.querytestproject.querydsl.study1.repository.OrderByNull;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.query.querytestproject.querydsl.study1.model.QStudy1User.study1User;
import static com.query.querytestproject.querydsl.study1.model.QStudy1Team.study1Team;
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositoryCustomImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }




    @Override
    public Boolean dslExist(String userId) {

        BooleanExpression exists = jpaQueryFactory.selectOne().from(study1User).where(study1User.userId.eq(userId)).exists();

        return jpaQueryFactory.select(exists).from(study1User).fetchOne();
    }

    @Override
    public Boolean dslFetchFirst(String userId) {

        Integer exists = jpaQueryFactory.selectOne().from(study1User).where(study1User.userId.eq(userId)).fetchFirst();
        return exists !=null;
    }


    @Override
    public Page<Study1PageUserDto> dslUserPage(Pageable pageable) {

        // 페치 조인은 dto로 조회 불가능

        List<Study1PageUserDto> content = jpaQueryFactory
                .select(Projections.constructor(Study1PageUserDto.class,
                        study1User.uuid,
                        study1User.userId,
                        study1User.userName,
                        study1User.userPassword,
                        study1Team.uuid,
                        study1Team.teamName
                ))
                .from(study1User)
                .join(study1User.team, study1Team)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPAQuery<Long> countQuery = jpaQueryFactory.select(study1User.count()).from(study1User);
        return PageableExecutionUtils.getPage(content,pageable,()->countQuery.fetchOne());
    }

    @Override
    public void dslUserOrderByTest() {
        //group by를 이용하면 order by가 굳이 fileSort가 발생한다. 이를 해결하기 위해서는 querydsl에서 따로 작업 해줘야 한다.

        jpaQueryFactory.selectFrom(study1User).groupBy(study1User.team.uuid).orderBy(OrderByNull.DEFAULT);
    }

    @Override
    public void dslChangeStaticValue(Study1UserStaticValueDto dto) {
        jpaQueryFactory.update(study1User).where(study1User.staticValue.eq(dto.getCurrentValue())).set(study1User.staticValue,dto.getChangeValue()).execute();
    }
}
