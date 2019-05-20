package com.goat.spring.chapter_02.javaconfig;

import com.goat.spring.chapter_02.ICompactDisc;
import com.goat.spring.chapter_02.IMediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 64274 on 2019/5/20.
 * @ Description:  javaconfig 包下的 两个实现类 是没有 @Component 注解的 但是通过 CDPlayerConfig 配置类的方式 进行了注入
 * @ author  山羊来了
 * @ date 2019/5/20---16:09
 */

@RestController
@RequestMapping("/javaconfig")
public class App2Controller {

    @Autowired
    private List<ICompactDisc> cds;

    // http://localhost:8303/javaconfig/test
    @GetMapping("test")
    public void test(){
        cds.get(1).play(); // *******************播放 CD 1111
    }

    @Autowired  private List<IMediaPlayer> ips;
    // http://localhost:8303/javaconfig/test2
    @GetMapping("test2")
    public void test2(){
        ips.get(1).insert();
    }

}
