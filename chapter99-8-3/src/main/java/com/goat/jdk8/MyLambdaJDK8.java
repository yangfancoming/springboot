package com.goat.jdk8;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class MyLambdaJDK8 {


    /**
     将一个字符串集合中的所有单词转为大写
     传统方式 和 lambda 实现方式
    */
    @Test
    public void toUpperCase1(){
        List<String> wordList = Arrays.asList("fuck","Shit","Egg","Nani","AJ");
        for (int i=0; i<wordList.size(); i++) {
            wordList.set(i,wordList.get(i).toUpperCase()); // 这里可以实现 改变list中的内容
        }
        System.out.println(wordList);
    }

    @Test
    public void toUpperCase2(){
        List<String> wordList = Arrays.asList("fuck","Shit","Egg","Nani","AJ");
        wordList.stream().map(w->w.toUpperCase()); // 这里不能实现 改变list中的内容
//        wordList.stream().forEach(x->x.toUpperCase());
        System.out.println(wordList);
    }




}
