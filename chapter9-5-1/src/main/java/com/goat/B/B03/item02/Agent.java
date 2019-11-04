package com.goat.B.B03.item02;

/**
 * Created by 64274 on 2018/7/25.
 *
 * @author 山羊来了
 * @Description: 代理角色
 * @date 2018/7/25---12:06
 */
public class Agent implements Perform {

    private Perform star; // 明星 真实角色


    public void setStar(Perform star) {
        this.star = star;
    }

    @Override
    public void sing() {
        clean();   // 静态代理 做的 前置增强
        star.sing();
        propaganda();  // 静态代理 做的 后置增强
    }

    @Override
    public void dance() {
        star.dance(); // 可以发现 代理 重写的接口方法  均由 真实角色调用
    }

    public void clean(){
        System.out.println("代理 在演唱会结束后 打扫卫生");
    }

    public void propaganda(){
        System.out.println("代理 在演唱会开始前 进行宣传");
    }
}
