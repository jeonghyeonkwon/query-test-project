package com.query.querytestproject.querydsl.study1.repository.querydsl;

import com.query.querytestproject.querydsl.study1.dto.BasicUserDto;
import com.query.querytestproject.querydsl.study1.model.QStudy1User;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import static com.query.querytestproject.querydsl.study1.model.QStudy1User.study1User;
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
    public Page<BasicUserDto> dslUserPage(Pageable pageable) {
        return null;
    }
}
