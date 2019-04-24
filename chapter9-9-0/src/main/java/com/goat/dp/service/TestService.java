package com.goat.dp.service;

import com.goat.dp.test.strategy.IDiscountStrategy2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TestService {

    Map<String, IDiscountStrategy2> map = new ConcurrentHashMap<>();

    public TestService() {}

    @Autowired  // doit  加了 无参构造函数 后 这里就必须要加 @Autowired ！ 否则  无法通过此构造方法注入！
    public TestService(List<IDiscountStrategy2> list) {
        for (IDiscountStrategy2 temp:list){
            map.put(temp.type(),temp); // 这里可以断下  证明了 多级子包 也可以扫描到
        }
    }

    public void sale3(String type,double price){
        Double discount = map.get(type).discount(price);
        System.out.println("本次 打折后价格为："+ discount);
    }
}
