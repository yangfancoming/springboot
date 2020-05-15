package com.goat.chapter002;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/5/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/5/12---13:28
 */

@RestController
public class HelloController {

    //    http://localhost:8002/hello
    @GetMapping("/hello")
    public String test(){
        return "123";
    }
}
