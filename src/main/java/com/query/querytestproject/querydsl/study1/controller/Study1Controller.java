package com.query.querytestproject.querydsl.study1.controller;

import com.query.querytestproject.querydsl.study1.service.Study1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study1")
public class Study1Controller {
    // https://www.youtube.com/watch?v=zMAX7g6rO_Y 실습 해보기
    private final Study1Service study1Service;
    @GetMapping("/init")
    public ResponseEntity init(){

        study1Service.initDb();

        return new ResponseEntity(HttpStatus.CREATED);
    }
}
