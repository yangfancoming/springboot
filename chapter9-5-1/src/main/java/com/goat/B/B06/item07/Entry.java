package com.goat.B.B06.item07;

/**
 * Created by 64274 on 2019/7/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/17---10:33
 */
public abstract class Entry {

    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) {
        throw new RuntimeException();
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
