package com.goat.fallback;

import com.goat.service.TestService;
import org.springframework.stereotype.Component;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param: 
     * @Return: 
     * @Date:   2018/11/27
*/
@Component
public class SchedualServiceHiHystric implements TestService {


    //需要重写的 熔断方法
    @Override
    public String testFuck() {
        return "sorry, you are fail,";
    }
}