package com.goat.controller;

import com.goat.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2020/1/14.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/14---9:42
 */
@RestController
@RequestMapping("/hello")
public class HelloController {



    // 测试地址：    http://localhost:8290/hello/success
    @RequestMapping("/success")
    public String success(String Name,Integer Price,String Category) {
        System.out.println(Name + Price + Category);
        return "success";
    }

    // 测试地址：    http://localhost:8290/hello/success2
    @RequestMapping("/success2")
    public String success(Product product) {
        System.out.println(product.getName() + product.getPrice() + product.getCategory());
        return "success2";
    }

    // 测试地址：    http://localhost:8290/hello/success3
    @RequestMapping("/success3")
    public String success(Object o) {
        System.out.println(o);
        return "success2";
    }
    /**
     * 多个请求参数填入到 map  spring会自动封装   使用map接收参数
     * http://localhost:8290/hello/requestParam2?ownerId=223&a=4&c=5
     * @param map
     */
    @RequestMapping("/requestParam2")
    public Object requestParam2(@RequestParam Map<String,Object> map) {
        System.out.println(map);
        return "wahaha";
    }

}
