package com.goat.C.C06;

/**
 * Created by 64274 on 2019/4/1.
 *
 * @ Description: 具体的命令对象ConcreteCommand：（开灯命令，关灯命令）
 * @ author  山羊来了
 * @ date 2019/4/1---9:38
 */
public class LightOffCommand implements Command{

    private Light light;

    /*** 创建关灯命令的时候，传入具体的灯对象，由灯对象操作自己*/
    public LightOffCommand(Light light) {
        this.light = light;
    }

    /*** 具体的灯对象调用自己的关灯方法*/
    @Override
    public void execute() {
        light.lightOff();
    }
}
