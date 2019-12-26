package com.goat.chapter239.observe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/11/28.
 *
 * @ Description: 观察着
 * @ author  山羊来了
 * @ date 2019/11/28---9:10
 */
@Component
public class Dao implements Observer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void save(byte[] msg) {
        try {
            logger.info("进入 Dao 的  save 方法!!");
        } catch (Exception e) {
            logger.info("接收到的仪表数据报文不完整，重新接收!!");
        }

    }
}
