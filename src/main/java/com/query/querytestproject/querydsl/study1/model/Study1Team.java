package com.query.querytestproject.querydsl.study1.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="STUDY1_TEAM")
@Getter
public class Study1Team {
    @Id
    @Column(name="TEAM_PK")
    private String uuid;

    private String teamName;

    protected Study1Team() {}

    public Study1Team(String uuid,String teamName){
        this.uuid = uuid;
        this.teamName = teamName;
    }
}
