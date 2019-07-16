package com.goat.B.B06.item04;

/**
 * Created by 64274 on 2019/7/16.
 *
 * @ Description: 公司类，抽象类或接口
 * @ author  山羊来了
 * @ date 2019/7/16---8:54
 */

public abstract class Company {

    protected String name;

    public Company(String name){
        this.name = name;
    }

    public abstract void add(Company c);//增加
    public abstract void remove(Company c);//移除


    public  void display(int depth){ //显示
        String str = "";//用于拼接'-',dept等于多少就表示拼接几个'-',用于显示效果
        for(int i=0;i<depth;i++){
            str +="-";
        }
        System.out.println(str+name);
    }


    public abstract void lineOfDuty();//履行职责
}
