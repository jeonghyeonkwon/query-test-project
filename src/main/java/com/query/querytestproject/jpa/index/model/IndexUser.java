package com.query.querytestproject.jpa.index.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "INDEX_USER_TABLE", indexes = {
        @Index(name = "category__index__user" ,columnList = "categoryEnum")
})
public class IndexUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String content;

    @Enumerated(EnumType.STRING)
    private IndexCategoryEnum categoryEnum;

    protected IndexUser(){}

    public IndexUser(String userName, String content, IndexCategoryEnum categoryEnum){
        this.userName = userName;
        this.content = content;
        this.categoryEnum =categoryEnum;
    }

}
