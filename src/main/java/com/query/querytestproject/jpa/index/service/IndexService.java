package com.query.querytestproject.jpa.index.service;

import com.query.querytestproject.jpa.index.model.IndexCategoryEnum;
import com.query.querytestproject.jpa.index.model.IndexUser;
import com.query.querytestproject.jpa.index.repository.IndexUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IndexService {
    private final IndexUserRepository indexUserRepository;
    @Transactional
    public void createInit() {

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        List<IndexUser> indexUser = new ArrayList<>();
        for(int i=0;i<60000;i++){
            int number = random.nextInt(3) + 1;
            IndexUser user = new IndexUser("유저 이름"+i,"내용"+i, IndexCategoryEnum.findNumber(number));
            indexUser.add(user);
        }
        indexUserRepository.saveAll(indexUser);
    }

    public List<IndexUser> basicSelect(Long number) {
        IndexCategoryEnum category = IndexCategoryEnum.findNumber(Math.toIntExact(number));
        return indexUserRepository.basicFindUserByCategory(category);

    }

    public List<IndexUser> indexSelect(Long number) {
        String category = IndexCategoryEnum.findNumber(Math.toIntExact(number)).toString();
        return indexUserRepository.indexFindUserByCategory(category);
    }
}
