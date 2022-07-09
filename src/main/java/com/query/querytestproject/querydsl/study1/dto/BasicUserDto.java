package com.query.querytestproject.querydsl.study1.dto;

import lombok.Data;

@Data
public class BasicUserDto {
    private String uuid;
    private String userId;
    private String userPassword;
    private Long sortValue;

    public BasicUserDto(String uuid, String userId, String userPassword, Long sortValue) {
        this.uuid = uuid;
        this.userId = userId;
        this.userPassword = userPassword;
        this.sortValue = sortValue;
    }
}
