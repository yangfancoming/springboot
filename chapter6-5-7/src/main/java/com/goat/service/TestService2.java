package com.goat.service;

import com.goat.annotation.Log;
import com.goat.domain.MyMoney;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 64274 on 2018/9/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/14---16:17
 */
@Service
public class TestService2 extends OtherService{

    @Log(title = "日志模块 函数")
    @Async("asyncTaskExecutor")
    public void saveAll2(List<MyMoney> lists) { //
        super.saveAll2(lists);
        System.out.println(Thread.currentThread().getName()+"111111111111111111111111111111111111");
    }

    @Async("asyncTaskExecutor")
    public void saveAll22(List<MyMoney> lists) { //
        super.saveAll22(lists);
    }
}

