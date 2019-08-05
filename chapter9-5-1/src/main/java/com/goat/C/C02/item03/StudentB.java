package com.goat.C.C02.item03;

/**
 * 学生甲抄的试卷
 */
public class StudentB extends TestPaper {

    String str = "学生B的答卷";

    @Override
    public String answer1() {
        return str + "b";
    }

    @Override
    public String answer2() {
        return str + "b";
    }

    @Override
    public String answer3() {
        return str + "b";
    }
}
