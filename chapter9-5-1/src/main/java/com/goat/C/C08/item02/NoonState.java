package com.goat.C.C08.item02;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---15:52
 */
public class NoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13){
            System.out.println("当前时间" + work.getHour() + "饿了，午饭，犯困，休息");
        } else {
            work.setState(new AfternoonState());
            work.writeProgram();
        }
    }
}

