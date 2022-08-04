package com.query.querytestproject.jpa.index.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "INDEX_USER_TABLE", indexes = {
        @Index(name = "userid__index__user" ,columnList = "id, userName")
})
public class IndexUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String content;


    protected IndexUser(){}

    public IndexUser(String userName, String content){
        this.userName = userName;
        this.content = content;
    }

}
