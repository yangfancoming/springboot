package com.goat.leetcode._136;

import org.junit.Test;

/**
 * Created by 64274 on 2019/5/8.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/8---9:30
 */
public class App {

    /*   136 题
        Given a non-empty array of integers, every element appears twice except for one. Find that single one.
        Note:
        Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

        Example 1:

        Input: [2,2,1]
        Output: 1
        Example 2:

        Input: [4,1,2,1,2]
        Output: 4
    * */

    @Test
    public void test(){
        int[] ints1 = {2, 2, 1};
        int[] ints2 = {4,1,2,1,2};
        int i = singleNumber(ints2);
        System.out.println(i);
    }

    /*
    1.任何数和本身异或为0  和 任何相同的两个数的异或为0
    2.任何数和 0 异或是本身

    第一个数组 运行结果可以理解
    第二个数组 运行时 ret = 0  4  5  7  6  4  异或 先加上去 异或到加过的数时 又减回去了。。。 ？！
    * */
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for(int n : nums)
            ret = ret ^ n;
        return ret;
    }
}
