package com.goat.C.C05.item03;

/**
 * Created by 64274 on 2019/9/22.
 *
 * @ Description: 注：之所以要在做任务的方法上传入接口或者是抽象类，是为了让渡流转业务。
 * @ author  山羊来了
 * @ date 2019/9/22---20:57
 */
public interface IResponsibility {

    // 处理逻辑的方法
    void doSomething(String input, IResponsibility responsibility);

}
