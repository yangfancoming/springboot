package com.goat.C.C08.item02;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---15:50
 */
public class Work {

    private State state;

    public Work() {
        // 初始化为上午工作状态
        state = new ForenoonState();
    }

    private double hour;
    private boolean finish = false;

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void writeProgram(){
        state.writeProgram(this);
    }
}

