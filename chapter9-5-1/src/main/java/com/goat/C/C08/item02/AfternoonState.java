package com.goat.C.C08.item02;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---15:51
 */
public class AfternoonState extends State {

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17){
            System.out.println("当前时间" + work.getHour() + "下午状态还不错，继续努力");
        } else {
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
