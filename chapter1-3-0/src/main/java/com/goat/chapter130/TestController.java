package com.goat.chapter130;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 64274 on 2019/10/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/22---11:00
 */
@RestController
public class TestController {

    private final static Log logger = LogFactory.getLog(TestController.class);

    @GetMapping("/test1")
    public void test1(){
        logger.debug("DEBUG ...");
        logger.info("INFO ...");
        logger.error("ERROR ...");
    }


}
