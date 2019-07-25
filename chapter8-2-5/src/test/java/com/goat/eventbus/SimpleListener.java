package com.goat.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 64274 on 2019/7/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/25---19:54
 */
public class SimpleListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(SimpleListener.class);

    /**
     * 一个简单的Listener方法  可以通过@Subscribe注解将任意的类的方法变为一个Listener
     * @param event Guava规定此处只能有一个参数
     */
    @Subscribe
    public void doAction(final String event){
        if (LOGGER.isInfoEnabled()){
            LOGGER.info("Received event [{}] and will take a action", event);
        }
    }
}
