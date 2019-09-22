package com.goat.B.B06.item07;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by 64274 on 2019/7/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/17---10:33
 */
public class Directory extends Entry {

    private String name;

    private ArrayList directory = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator it = directory.iterator();
        while(it.hasNext()) {
            Entry entry = (Entry)it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while(it.hasNext()) {
            Entry entry = (Entry)it.next();
            entry.printList(prefix + "/" + name);
        }
    }

}

