package com.query.querytestproject.querydsl.study1.controller;

import com.query.querytestproject.querydsl.study1.service.Study1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/study1")
public class Study1Controller {
    // https://www.youtube.com/watch?v=zMAX7g6rO_Y 실습 해보기
    private final Study1Service study1Service;
    @GetMapping("/init")
    public ResponseEntity init(){
        System.out.println("데이터 초기화중");
        study1Service.initDb();

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/user/exist")
    public ResponseEntity findUserExist(@RequestParam("userId") String userId){
        return study1Service.findExist(userId);

    }
    @GetMapping("/user/fetch-first")
    public ResponseEntity findUserFetchFirst(@RequestParam("userId") String userId){
        return study1Service.findFetchFirst(userId);
    }
//
//    @GetMapping("/user")
//    public ResponseEntity list(@PageableDefault(size = 10,sort = "sortValue",direction = Sort.Direction.ASC)Pageable pageable){
//        return study1Service.list(pageable);
//    }
}
