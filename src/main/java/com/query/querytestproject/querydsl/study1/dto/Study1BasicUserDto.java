package com.query.querytestproject.querydsl.study1.dto;

import lombok.Data;

@Data
public class Study1BasicUserDto {
    private String uuid;
    private String userId;
    private String userPassword;
    private Long sortValue;

    public Study1BasicUserDto(String uuid,
                              String userId,
                              String userPassword,
                              Long sortValue) {
        this.uuid = uuid;
        this.userId = userId;
        this.userPassword = userPassword;
        this.sortValue = sortValue;
    }
}
