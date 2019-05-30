package com.goat.C.C03.item01;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/30---13:41
 */
public class App {

    public static void main(String[] args) {

        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userWang = new User("WangWu");
        Observer userLi = new User("LiSi");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");
    }
}
