package com.goat.Z.Z06.example01;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---13:28
 */
public class Driver {

    //在这里产生了实体类之间的依赖  // 此处需要修改
    public void drive(Bmw bmw){
        bmw.run();
    }
}
