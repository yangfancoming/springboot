package com.goat.A04;

/**
 * Created by 64274 on 2018/8/7.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/7---9:07
 */
public class A {
    //A对象重写equals方法，如果删除A对象，List用其中的对象对比A对象的equals方法，如果返回 true ,就删除对象。
    @Override
    public boolean equals(Object obj){
        return true;
    }
}
