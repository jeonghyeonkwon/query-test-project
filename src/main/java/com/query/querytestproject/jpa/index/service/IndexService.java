package com.query.querytestproject.jpa.index.service;

import com.query.querytestproject.jpa.index.model.IndexUser;
import com.query.querytestproject.jpa.index.repository.IndexUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IndexService {
    private final IndexUserRepository indexUserRepository;
    @Transactional
    public void createInit() {

        List<IndexUser> indexUser = new ArrayList<>();
        for(int i=0;i<60000;i++){
            IndexUser user = new IndexUser("유저 이름"+i,"내용"+i);
            indexUser.add(user);
        }
        indexUserRepository.saveAll(indexUser);
    }
}
