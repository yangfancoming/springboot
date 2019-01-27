package com.goat.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by 64274 on 2018/10/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/23---11:55
 */
public class SecondListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("销毁 SecondListener...");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println(" 进入 SecondListener...");
    }
}
