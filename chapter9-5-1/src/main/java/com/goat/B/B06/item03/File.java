package com.goat.B.B06.item03;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/15---21:16
 */
public abstract class File {
    String name;

    public File(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void display();
}