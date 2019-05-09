package com.goat.A03;

import org.junit.Test;

/**
 * Created by 64274 on 2019/5/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/9---14:54
 */
public class BreakCyc {

    String[] array = new String[] { "白鹭", "丹顶鹤", "黄鹂", "鹦鹉", "乌鸦", "喜鹊","老鹰", "布谷鸟", "老鹰", "灰纹鸟", "老鹰", "百灵鸟" };
    int[][] myScores = new int[][] { { 67, 78, 63, 22, 66 },{ 55, 68, 78, 95, 44 }, { 95, 97, 92, 93, 81 } };

    /*  中断单层循环的例子 */
    @Test
    public void test1(){
        System.out.println("在你发现第一只老鹰之前，告诉我都有什么鸟。");
        for (String string : array) {
            if (string.equals("老鹰"))
                break; // sos  中断单层循环
            System.out.print("有：" + string+"        ");
        }
    }

    /*  中断双层循环的例子 */
    @Test
    public void test2(){
        System.out.println("宝宝这次考试成绩：\n数学\t语文\t英语\t美术\t历史");
        No1: for (int[] is : myScores) {// 遍历成绩表格
            for (int i : is) {
                System.out.print(i + "\t");// 输出成绩
                if (i < 60) {// 如果中途遇到不及格的，立刻中断所有输出
                    System.out.println("\n等等，" + i + "分的是什么？这个为什么不及格？");
                    break No1; // sos  中断双层循环
                }
            }
            System.out.println();
        }
    }

}