package com.goat.chapter130;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2020/9/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/9/10---14:16
 */

@RestController
@RequestMapping("demo")
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    // http://localhost:8130/demo/test1
    @GetMapping("test1")
    public void test1() throws InterruptedException {
        for(int i = 0; i < 500; i++) {
            log.info("{}", i);
            log.info("logger.info\n");
            Thread.sleep(100);//为了防止50000条很快跑完，sleep一段时间
        }
    }
}
