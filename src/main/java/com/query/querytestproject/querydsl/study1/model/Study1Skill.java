package com.query.querytestproject.querydsl.study1.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name="STUDY1_SKILL")
@Getter
public class Study1Skill {

    @Id
    @Column(name="SKILL_PK")
    private String uuid;

    private String skillName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_PK")
    private Study1User user;

    protected Study1Skill(){}

    public Study1Skill(String uuid,
                       String skillName,
                       Study1User user){
        this.uuid = uuid;
        this.skillName = skillName;
        this.user = user;
        user.getStudy1SkillList().add(this);
    }

}
