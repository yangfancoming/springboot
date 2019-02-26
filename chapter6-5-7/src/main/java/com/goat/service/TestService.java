package com.goat.service;

import com.goat.domain.MyMoney;
import com.goat.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

//    @Retryable(value = {RuntimeException.class},  backoff = @Backoff(delay = 1500L, multiplier = 1))
    @Async("asyncTaskExecutor")
    @Transactional
    public void saveAll1(List<MyMoney> lists) { // 可以回滚
        System.out.println("进入 saveAll。。。。。。。。。。。");
        testRepository.saveAll(lists);
        throw new RuntimeException("saveAll  回滚测试。。。。。。。。。。。。。。");
    }

    @Autowired OtherService otherService;

    @Async("asyncTaskExecutor")
    public void saveAll2(List<MyMoney> lists) { // 可以回滚
        otherService.saveAll2(lists,"");
    }

}

