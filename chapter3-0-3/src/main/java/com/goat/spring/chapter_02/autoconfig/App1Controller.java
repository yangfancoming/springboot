package com.goat.spring.chapter_02.autoconfig;

import com.goat.spring.chapter_02.ICompactDisc;
import com.goat.spring.chapter_02.IMediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 64274 on 2019/5/20.
 * @ Description: autoconfig 包下的两个实现类 是通过 @Component 注解 来进行注入的
 * @ author  山羊来了
 * @ date 2019/5/20---16:09
 */

@RestController
@RequestMapping("/autoconfig")
public class App1Controller {

    @Autowired private List<ICompactDisc> cds;
    // http://localhost:8303/autoconfig/test
    @GetMapping("test")
    public void test(){
        cds.get(0).play(); // *******************播放 CD
    }

    @Autowired private ApplicationContext ac;

    //  http://localhost:8303/autoconfig/test1
    @GetMapping("test1")
    public void test1(){
        System.out.println(ac.containsBean("MycomId")); //true
        System.out.println(ac.containsBean("compactDiscImpl")); //false
        System.out.println(ac.containsBean("compactDiscImp2")); //false
        System.out.println(ac.containsBean("mediaPlayerImpl")); //true
        System.out.println(ac.containsBean("MediaPlayerImpl")); //false
        System.out.println(ac.containsBean("MediaPlayerImp2")); //false
        Arrays.stream(ac.getBeanDefinitionNames()).forEach(System.out::println);
    }

    @Autowired  private List<IMediaPlayer> ips;
    // http://localhost:8303/autoconfig/test2
    @GetMapping("test2")
    public void test2(){
        ips.get(0).insert();
    }

}
