package com.goat.service;

import com.goat.domain.MyMoney;
import com.goat.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * Created by 64274 on 2018/9/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/14---16:17
 */
@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    public Optional<MyMoney> findById(Long id) {
        return testRepository.findById(id);
    }

    @Transactional
    public void save(MyMoney myMoney) {
         testRepository.save(myMoney);
    }


}
