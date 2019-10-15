package com.goat.B.B07.item04;

import org.junit.Test;

/**
 * 享元模式——网站共享（不同网站，相同核心）
 */
public class App {

    @Test
    public void test(){
        WebSiteFactory factory = new WebSiteFactory();

        WebSite fx = factory.getWebSiteCategory("产品展示");
        fx.use(new User("adam"));

        WebSite fy = factory.getWebSiteCategory("产品展示");
        fy.use(new User("bill"));

        WebSite fz = factory.getWebSiteCategory("产品展示");
        fz.use(new User("mary"));

        WebSite fa = factory.getWebSiteCategory("博客");
        fa.use(new User("tom"));

        WebSite fb = factory.getWebSiteCategory("博客");
        fb.use(new User("ben"));

        WebSite fc = factory.getWebSiteCategory("博客");
        fc.use(new User("sally"));

        System.out.println("网站分类总数为：" + factory.getWebSiteCount());
    }

	
}
