package com.query.querytestproject.jpa.index.controller;

import com.query.querytestproject.jpa.index.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/index-test")
public class IndexController {
    private final IndexService indexService;


    @GetMapping("/init")
    public ResponseEntity indexUserInit(){
        indexService.createInit();
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
