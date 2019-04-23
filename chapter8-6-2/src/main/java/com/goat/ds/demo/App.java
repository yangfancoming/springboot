package com.goat.ds.demo;

/**
 * Created by 64274 on 2019/4/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/4/23---10:30
 */
public class App {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        LinkList list = new LinkList();
        for (int i = 0; i < 10; i++) {
            int temp = ((int) (Math.random() * 100)) % 100;
            list.insert(i, temp);
            System.out.print(temp + " ");
        }

        list.delete(4);
        System.out.println("\n------删除第五个元素之后-------");
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
