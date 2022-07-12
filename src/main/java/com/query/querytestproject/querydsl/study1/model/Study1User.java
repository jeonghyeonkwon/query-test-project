package com.query.querytestproject.querydsl.study1.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDY1_USER")
@Getter
public class Study1User {
    @Id
    @Column(name="USER_PK")
    private String uuid;

    private String userId;

    private String userPassword;

    private String userName;

    private String address;
    private Long staticValue;

    @OneToMany(mappedBy = "user")
    private List<Study1Skill> study1SkillList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TEAM_PK")
    private Study1Team team;

    //몇 개 생성되었는지 확인차
    private Long sortValue;

    protected Study1User(){}

    public Study1User(String uuid,
                      String userId,
                      String userPassword,
                      String userName,
                      String address,
                      Long sortValue,
                      Long staticValue,
                      Study1Team team){
        this.uuid = uuid;
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.address = address;
        this.sortValue = sortValue;
        this.staticValue = staticValue;
        this.team = team;
    }

    public void updateStaticValue(Long changeValue) {
        this.staticValue = changeValue;
    }
}
