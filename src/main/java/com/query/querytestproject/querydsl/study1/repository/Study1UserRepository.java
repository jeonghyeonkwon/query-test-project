package com.query.querytestproject.querydsl.study1.repository;


import com.query.querytestproject.querydsl.study1.model.Study1User;
import com.query.querytestproject.querydsl.study1.repository.querydsl.UserRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface Study1UserRepository extends JpaRepository<Study1User,String> , UserRepositoryCustom {

    @Query("SELECT user FROM Study1User user WHERE user.staticValue =: currentValue")
    List<Study1User> findUserByStaticValue(Long currentValue);
}
