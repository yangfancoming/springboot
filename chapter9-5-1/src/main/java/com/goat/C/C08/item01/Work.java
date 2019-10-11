package com.goat.C.C08.item01;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/11---15:44
 */
public class Work {
    /**
     * 时间点
     */
    private int hour;
    /**
     * 工作是否完成
     */
    private boolean finish = false;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void writeProgram(){
        if (hour < 12){
            System.out.println("当前时间" + hour + "上午工作，精神百倍");
        } else if (hour < 13){
            System.out.println("当前时间" + hour + "饿了，午饭，犯困，休息");
        } else if (hour < 17){
            System.out.println("当前时间" + hour + "下午状态还不错，继续努力");
        } else {
            if (finish){
                System.out.println("当前时间" + hour + "下班回家了");
            } else if (hour < 21){
                System.out.println("当前时间" + hour + "加班哦，好难受");
            } else {
                System.out.println("当前时间" + hour + "不行了，睡着了");
            }
        }
    }
}

