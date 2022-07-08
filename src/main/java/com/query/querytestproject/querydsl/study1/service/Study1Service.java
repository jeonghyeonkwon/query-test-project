package com.query.querytestproject.querydsl.study1.service;

import com.query.querytestproject.querydsl.study1.model.Study1Skill;
import com.query.querytestproject.querydsl.study1.model.Study1Team;
import com.query.querytestproject.querydsl.study1.model.Study1User;
import com.query.querytestproject.querydsl.study1.repository.Study1SkillRepository;
import com.query.querytestproject.querydsl.study1.repository.Study1TeamRepository;
import com.query.querytestproject.querydsl.study1.repository.Study1UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class Study1Service {
    private final Study1UserRepository userRepository;
    private final Study1TeamRepository teamRepository;
    private final Study1SkillRepository skillRepository;

    @Transactional
    public void initDb() {

            Study1Team team1 = new Study1Team(UUID.randomUUID().toString(),"팀1");
            Study1Team team2 = new Study1Team(UUID.randomUUID().toString(),"팀2");

            teamRepository.save(team1);
            teamRepository.save(team2);

        for(int i=1;i<=1000;i++){
            Study1User user;
            if(i%2==0){
                user = new Study1User(UUID.randomUUID().toString(),
                        "userId"+i,"userPassword"+i,"유저이름" + i,"주소"+i,team1);

            }
            else{
                user = new Study1User(UUID.randomUUID().toString(),
                        "userId"+i,"userPassword"+i,"유저이름" + i,"주소"+i,team2);

            }
            userRepository.save(user);
            List<Study1Skill> skillList = new ArrayList<>();
            for(int j=1; j<=3;j++){
                Study1Skill skill = new Study1Skill(UUID.randomUUID().toString(),"user"+i+"의 기술",user);
                skillList.add(skill);
            }
            skillRepository.saveAll(skillList);
        }
    }
}
