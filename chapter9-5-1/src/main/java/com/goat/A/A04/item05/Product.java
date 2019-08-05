package com.goat.A.A04.item05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/8/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/5---9:32
 */
public class Product {

    List<String> parts = new ArrayList<>();

    // 添加产品部件
    public void add(String part) {
        parts.add(part);
    }

    // 列举所有的产品部件
    public void show() {
        System.out.println("\n产品 创建 ----");
        parts.stream().forEach(x->System.out.println(x));
    }
}

