package com.query.querytestproject.querydsl.study1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Study1Service {

    @Transactional
    public void initDb() {


    }
}
