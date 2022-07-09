package com.query.querytestproject.querydsl.study1.repository.querydsl;

import com.query.querytestproject.querydsl.study1.dto.BasicUserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {

    Boolean dslExist(String userId);
    Boolean dslFetchFirst(String userId);

    Page<BasicUserDto> dslUserPage(Pageable pageable);

}
