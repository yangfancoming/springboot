package com.goat.model;

/**
 * Created by 64274 on 2019/8/6.
 *
 * @ Description: 声明多个构造函数
 * @ author  山羊来了
 * @ date 2019/8/6---15:16
 */
public class Constructor2 {

    int id;
    String name;

    public Constructor2() {
    }

    public Constructor2(int id) {
        this.id = id;
    }

    public Constructor2(String name) {
        this.name = name;
    }

    private Constructor2(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
