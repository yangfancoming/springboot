package com.goat.test;

import com.goat.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 64274 on 2019/2/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/13---11:56
 */

@RestController
@RequestMapping("put")
public class PutTest {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/put")
    public void put() {
        User user = new User();
        user.setName("红楼梦");
        restTemplate.put("http://HELLO-SERVICE/getbook3/{1}", user, 99);
    }

}
