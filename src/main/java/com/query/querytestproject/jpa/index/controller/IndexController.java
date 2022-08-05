package com.query.querytestproject.jpa.index.controller;

import com.query.querytestproject.jpa.index.model.IndexUser;
import com.query.querytestproject.jpa.index.service.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/index-test")
@Slf4j
public class IndexController {
    private final IndexService indexService;


    @GetMapping("/init")
    public ResponseEntity indexUserInit(){
        indexService.createInit();
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/basic/{number}")
    public ResponseEntity basicCategorySelect(@PathVariable Long number){
        long start = System.currentTimeMillis();
        List<IndexUser> indexUsers = indexService.basicSelect(number);
        long end = System.currentTimeMillis();
        log.info("조회 카테고리 : {}, 실행 시간 : {}ms",number,(end-start));
        return new ResponseEntity(indexUsers,HttpStatus.OK);
    }
    @GetMapping("/index/{number}")
    public ResponseEntity indexCategorySelect(@PathVariable Long number){
        long start = System.currentTimeMillis();
        List<IndexUser> indexUsers = indexService.indexSelect(number);
        long end = System.currentTimeMillis();
        log.info("인덱스 사용 조회 카테고리 : {}, 실행 시간 : {}ms",number,(end-start));
        return new ResponseEntity(indexUsers,HttpStatus.OK);
    }
}
