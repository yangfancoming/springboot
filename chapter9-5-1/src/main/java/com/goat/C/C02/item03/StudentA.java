package com.goat.C.C02.item03;

/**
 * 学生甲抄的试卷
 */
public class StudentA extends TestPaper {

    String str = "学生A的答卷";

    @Override
    public String answer1() {
        return str + "a";
    }

    @Override
    public String answer2() {
        return str + "a";
    }

    @Override
    public String answer3() {
        return str + "a";
    }
}
