package com.goat.B.B06.item07;

/**
 * Created by 64274 on 2019/7/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/17---10:33
 */
public class File extends Entry {

    private String name;

    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + '/' + this);
    }

}
