package com.goat.chapter461;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {


    @Autowired
    CarRepository carRepository;

    // 测试地址： http://localhost:8461/hello/test1
    @RequestMapping("/test1")
    public void hellola(){

        Car car = new Car("1","2","3","4");
        Car save = carRepository.save(car);
        System.out.println(save);
    }

}
