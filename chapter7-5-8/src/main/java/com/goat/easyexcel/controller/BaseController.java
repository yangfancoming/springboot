package com.goat.easyexcel.controller;

import java.util.List;

/**
 * Created by 64274 on 2019/2/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/23---21:41
 */
public class BaseController {


    /**
     带模型解析与不带模型解析主要在构造new Sheet(1, 2, LoanInfo.class)时候包含class
     Class需要继承BaseRowModel暂时BaseRowModel没有任何内容，后面升级可能会增加一些默认的数据
    */
    public void print(List<Object> datas){
        int i=0;
        for (Object ob:datas) {
            System.out.println(i++);
            System.out.println(ob);
        }
    }
}
