package com.goat.B.B06.item03;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/15---21:17
 */
public class TextFile extends File{

    public TextFile(String name) {
        super(name);
    }

    @Override
    public void display() {
        System.out.println("这是文本文件，文件名：" + super.getName());
    }

}