package com.query.querytestproject.querydsl.study1.repository.querydsl;

import com.query.querytestproject.querydsl.study1.dto.Study1PageUserDto;
import com.query.querytestproject.querydsl.study1.dto.Study1UserStaticValueDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {

    Boolean dslExist(String userId);
    Boolean dslFetchFirst(String userId);

    Page<Study1PageUserDto> dslUserPage(Pageable pageable);


    void dslUserOrderByTest();

    void dslChangeStaticValue(Study1UserStaticValueDto dto);

}
