package com.goat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2019/12/24.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/24---17:52
 */
public class App {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void testConsole2(){
        for(int i = 0;i < 10000;i ++){
            log.info("这里是在控制台中输出的信息。");
        }
    }
}
