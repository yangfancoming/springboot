package com.goat.C.C06;

/**
 * Created by 64274 on 2019/4/1.
 *
 * @ Description: 传递命令对象Invoker：
 * @ author  山羊来了
 * @ date 2019/4/1---9:57
 */
public class XiaoAi {

    private Command command;

    /** 设置具体的命令*/
    public void setCommand(Command command) {
        this.command = command;
    }

    /** 执行命令*/
    public void doCommand() {
        command.execute();
    }
}
