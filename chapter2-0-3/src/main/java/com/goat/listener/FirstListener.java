package com.goat.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by 64274 on 2018/10/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/23---11:55
 *
<!-- Spring监听器 -->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>

 项目启动后  查看 控制台 打印信息  既可看出来
 */

@WebListener
public class FirstListener implements ServletContextListener {


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("WebAppListener通过注解实现的监听器已销毁...");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("WebAppListener通过注解实现的监听器开始初始化...");
    }


}
