package com.goat;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created by Administrator on 2019/12/24.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/24---17:11
 */
public class App {

    private static final Logger log = Logger.getLogger(App.class);

    @Test
    public void testConsole2(){
        for(int i = 0;i < 10000;i ++){
            log.info("这里是在控制台中输出的信息。");
        }
    }

}
