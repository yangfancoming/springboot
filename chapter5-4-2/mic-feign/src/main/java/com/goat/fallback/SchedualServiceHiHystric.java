package com.goat.fallback;

import com.goat.service.TestService;
import org.springframework.stereotype.Component;



@Component
public class SchedualServiceHiHystric implements TestService {

    //需要重写的 熔断方法
    @Override
    public String testFuck() {
        return "sorry, you are fail,";
    }
}