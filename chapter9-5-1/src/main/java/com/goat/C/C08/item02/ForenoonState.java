package com.goat.C.C08.item02;


/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---15:49
 */
public class ForenoonState extends State {

    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12){
            System.out.println("当前时间" + work.getHour() + "上午工作，精神百倍");
        } else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}

