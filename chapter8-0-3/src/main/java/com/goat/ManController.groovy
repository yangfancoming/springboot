package com.goat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by 64274 on 2018/11/29.
 * @Description: TODO* @author 山羊来了* @date 2018/11/29---13:33
 */
@RestController
class ManController {

    @Autowired
    private ManService manService


    //  测试地址：http://localhost:8080/ok
    @GetMapping("/ok")
    String home() {
        Man man = manService.getInfoByName("mickjoust")
        return "ok ==> groovy "+"name:"+man.name
    }
}
