package com.goat.C.C02.item03;




public class App {

    public static void main(String[] args) {

        System.out.println("学生甲做的试卷：2");
        StudentA studentA = new StudentA();
        studentA.testQuestion1();
        studentA.testQuestion2();
        studentA.testQuestion3();

        System.out.println();

        System.out.println("学生乙做的试卷：2");
        StudentB studentB = new StudentB();
        studentB.testQuestion1();
        studentB.testQuestion2();
        studentB.testQuestion3();
    }
}
