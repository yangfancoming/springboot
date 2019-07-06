package com.goat.A09;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 E - Element (在集合中使用，因为集合中存放的是元素)
 T - Type（Java 类）
 K - Key（键）
 V - Value（值）
 N - Number（数值类型）
 ? -  表示不确定的java类型

 举例说明：
 Set<T> 表示 集合里 是   T类的实例
 List<E> 表示  集合里 是  E类的实例
 List<?> 表示 集合里的对象类型不确定，未指定
 List 同 List<?> 是一样的。

 泛型的作用：
 1、用泛型：
 List<T> list=new ArrayList<T>();
 T t=list.get(0);

 2、不用泛型：
 List  list=new ArrayList();
 T t=(T)list.get(0);
 */
public class App {

    public static List<SuccessModel> parseArray(String response){
        List<SuccessModel> modelList = JSON.parseArray(response, SuccessModel.class);
        return modelList;
    }

    //首先，我们应该把SuccessModel单独抽出来做为泛型变量，但parseArray（）中用到的SuccessModel.class要怎么弄呢？ 先来看代码：
    public static <T> List<T> parseArray(String response,Class<T> object){
        List<T> modelList = JSON.parseArray(response, object);
        return modelList;
    }
}
