package com.goat.C.C08.item04;

import org.junit.Test;

/**
 * Created by 64274 on 2019/10/11.
 *
 * @ Description:
 * @ author  山羊来了
 * @ date 2019/10/11---15:45
 *
 考虑一个银行系统，可以用来取款、打电话、报警、记录这四种功能，但是考虑如下需求：
 在白天如果我们去取款是正常的，晚上取款就要发出警报；
 在白天打电话有人接，晚上打电话启动留言功能；白天和晚上按警铃都会报警。
 那么我们应该如何设计这个程序呢，当然我们可以对每一个动作（作为一个函数），
 在这个函数内部，我们进行判断是白天还是黑夜，然后根据具体的情况做出反应。
 这样当然是可以的，但是假如我们的状态（白天和黑夜）非常的多呢，比如将24小时分成24个时间段（24个状态），
 那么我们对于每一个函数就要判断24遍，这无疑是非常糟糕的代码，可读性非常的差，并且如果需求发生了改变，我们很难去修改代码（很容易出现错误），
 但是如果我们考虑将这些状态都作为一个类，在每一个类内部进行处理、判断和相应的切换，这样思路就非常的清晰，
 如果再增加一种状态，代码需要修改的地方会非常的少，对于状态非常多的情景来说非常的方便
 */
public class App {

    @Test
    public void test(){

    }

    public static void main(String[] args) {

        SafeFrame f=new SafeFrame("状态模式");
        while(true){
            for(int hour = 1;hour <= 24;hour++){
                f.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
