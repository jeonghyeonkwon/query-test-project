package com.query.querytestproject.querydsl.study1.dto;

import lombok.Data;

@Data
public class Study1PageUserDto {
    private String userUUID;
    private String userId;
    private String userName;
    private String userPassword;
    private String teamUUID;
    private String teamName;

    public Study1PageUserDto(String userUUID,
                             String userId,
                             String userName,
                             String userPassword,
                             String teamUUID,
                             String teamName) {
        this.userUUID = userUUID;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.teamUUID = teamUUID;
        this.teamName = teamName;
    }
}
