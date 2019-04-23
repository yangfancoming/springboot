package com.goat.ds.demo;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---10:26
 */
public interface MyList {

    //获得线性表长度
    public int size();

    //判断线性表是否为空
    public boolean isEmpty();

    //插入元素
    public void insert(int index, Object obj) throws Exception;

    //删除元素
    public void delete(int index) throws Exception;

    //获取指定位置的元素
    public Object get(int index) throws Exception;
}
