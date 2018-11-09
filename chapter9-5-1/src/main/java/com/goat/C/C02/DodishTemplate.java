package com.goat.C.C02;

/**
 * Created by 64274 on 2018/11/4.
 *
 * @author 山羊来了
 * @Description: 炒菜 模板抽象类
 * @date 2018/11/4---16:34
 */
public abstract class DodishTemplate {

    public Boolean spit = false;// 默认不往菜里吐痰
    protected final void dodish(){  // 具体的整个过程
        pourOil();
        preparation();
        doing();
        if(spit){ //模板方法模式的拓展（钩子方法）
            Spit();
        }
        carriedDishes();
    }
    //第一步：倒油在所有子类实现里都是一样的，所以 父类 直接实现
    public void pourOil(){
        System.out.println("倒油");
    }
    // 备料
    public abstract void preparation();
    // 做菜
    public abstract void doing();
    // 吐痰
    public  void Spit(){
        System.out.println("这个顾客很装逼,往菜里吐痰,搞他！");
    }
    //上菜
    public abstract void carriedDishes ();
}
