package com.query.querytestproject.querydsl.study1.repository;


import com.query.querytestproject.querydsl.study1.model.Study1User;
import com.query.querytestproject.querydsl.study1.repository.querydsl.UserRepositoryCustom;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Study1UserRepository extends JpaRepository<Study1User,String> , UserRepositoryCustom {

}
