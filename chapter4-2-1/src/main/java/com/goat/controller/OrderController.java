package com.goat.controller;

import com.goat.domain.Order;
import com.goat.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 64274 on 2019/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/6---14:39
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    //  http://localhost:8421/order/test1
    @GetMapping("/test1")
    public List<Order> test1(){
        List<Long> ts = Arrays.asList(3L, 4L, 6L);
        List<Order> findbyids = orderRepository.findbyids(ts);
        return findbyids;
    }
}
