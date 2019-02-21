package com.goat.service;

import com.goat.domain.MyMoney;
import com.goat.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 64274 on 2019/2/21.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/21---19:42
 */
public class BaseService {

    @Autowired
    TestRepository testRepository;

    @Transactional
    public void save(MyMoney myMoney){
//        try {  //  这里捕获异常 不能回滚！
            testRepository.save(myMoney);
            throw new RuntimeException("hahaha");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
