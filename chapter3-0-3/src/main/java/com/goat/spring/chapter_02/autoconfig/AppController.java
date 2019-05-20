package com.goat.spring.chapter_02.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/5/20.
 * @ Description: 测试 控制器
 * @ author  山羊来了
 * @ date 2019/5/20---16:09
 */

@RestController
@RequestMapping("/02")
public class AppController {

    @Autowired
    private ICompactDisc cd;

    // http://localhost:8303/02/test
    @GetMapping("test")
    public void test(){
        cd.play();
    }

    @Autowired private ApplicationContext ac;

    // http://localhost:8303/02/test1
    @GetMapping("test1")
    public void test1(){
        System.out.println(ac.containsBean("MycomId")); //true
        System.out.println(ac.containsBean("compactDiscImpl")); //false
        System.out.println(ac.containsBean("mediaPlayerImpl")); //true
        System.out.println(ac.containsBean("MediaPlayerImpl")); //false
    }

    // http://localhost:8303/02/test2
    @GetMapping("test2")
    public void test2(){
        IMediaPlayer bean = ac.getBean(IMediaPlayer.class);
        bean.insert();
    }

}
