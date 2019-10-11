package com.goat.C.C08.item02;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---15:52
 */
public class EveningState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinish()){
            work.setState(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21){
                System.out.println("当前时间" + work.getHour() + "加班哦，好难受");
            } else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
