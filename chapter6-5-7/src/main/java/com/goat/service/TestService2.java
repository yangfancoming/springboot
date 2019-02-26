package com.goat.service;

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

    @Async("asyncTaskExecutor")
    public void test21(List<MyMoney> lists) { //
        super.saveAll2(lists);
    }
    @Async("asyncTaskExecutor")
    public void test22(List<MyMoney> lists) { //
        super.saveAll22(lists);
    }
}

