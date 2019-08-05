package com.goat.C.C02.item03;

/**
 *  试卷
 */
public abstract class TestPaper {

    public void testQuestion1() {
        System.out.println("第一题：杨过得到，后来给了郭靖，" + "炼成倚天剑、屠龙刀的玄铁可能是[ ]\n" + "a.球墨铸铁 b.马口铁 c.高速合金钢 d.碳素纤维");
        System.out.println("答案: " + answer1());
    }

    public void testQuestion2() {
        System.out.println("第二题：杨过、程英、陆无双铲除了情花，造成[ ]\n" +"a.使这种植物不再伤人 b.使一种珍惜物种灭绝\n" + "c.破坏了那个生物圈的生态平衡 d.造成该地区荒漠化");
        System.out.println("答案: " + answer2());
    }

    public void testQuestion3() {
        System.out.println("第三题：蓝凤凰致使华山师徒、桃谷六仙呕吐不止，" +"如果你是大夫，会给他们开什么药[ ]\n" +"a.阿司匹林 b.牛黄解毒片 c.氟哌酸 d.大量生牛奶");
        System.out.println("答案: " + answer3());
    }

    public abstract String answer1();
    public abstract String answer2();
    public abstract String answer3();
}
