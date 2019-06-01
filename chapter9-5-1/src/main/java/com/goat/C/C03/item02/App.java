package com.goat.C.C03.item02;

/**
 * Created by 64274 on 2019/5/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/30---14:12
 */
public class App {

    public static void main(String[] args) {
        Wolf wolf = new Wolf();  // 灰太狼--被观察者

        Observer pleasantSheep = new PleasantSheep();   // 喜羊羊--观察者
        wolf.attach(pleasantSheep);  // 登记观察者

        Observer lazySheep = new LazySheep();// 懒羊羊--观察者
        wolf.attach(lazySheep);  // 登记观察者

        wolf.dettach(pleasantSheep);  // 删除观察者
        wolf.invade(); // 灰太狼入侵
    }
}
