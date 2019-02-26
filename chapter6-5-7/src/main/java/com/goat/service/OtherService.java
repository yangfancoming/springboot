package com.goat.service;

import com.goat.domain.MyMoney;
import com.goat.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 64274 on 2019/2/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/26---10:52
 */
@Service
public class OtherService {

    @Autowired
    TestRepository testRepository;

    @Transactional
    public void saveAll2(List<MyMoney> lists,String code) { // 可以回滚
        System.out.println("进入 saveAll2 。。。。。。。。。。。");
        testRepository.saveAll(lists);
        if (code.equals("3")) throw new RuntimeException("3 号 线程回滚。。。。。。。。。。。。。。");
    }

    @Transactional
    public List<MyMoney> saveAll22(List<MyMoney> lists,String code) {
        System.out.println("进入 saveAll22 。。。。。。。。。。。");
        List<MyMoney> myMonies = testRepository.saveAll(lists);
        if (code.equals("3")) {
            throw new RuntimeException("3 号 线程回滚。。。。。。。。。。。。。。");
        }
        return myMonies;
    }
}
