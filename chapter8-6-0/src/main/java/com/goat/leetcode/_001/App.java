package com.goat.leetcode._001;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class App {
    /**
     *   给定一个整型数组和一个整数 target 如果数组中 任意两个元素之和 等于 target 则返回 两个元素的索引
     *   思路：
     *   反向思维 相当于 将一维数组转成map集合   key 为 差值， value 为 数组索引 然后对数组遍历时每次都检测map是否已经存在，如果存在则匹配完成。
     *   一维数组 {2, 8, 11, -2}  target = 9
     *   转换为map  {7, 1, -2, ok}     当数组遍历到 最后一个-2时，map中已经存在了-2，则匹配完成
    */

    @Test
    public void test(){
        int[] nums = new int[]{2, 8, 11, -2};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    @Test
    public void test1(){
        int[] a = new int[] {7,1,3,2,11,34,6,9,32,8};
        int target = 13;
        System.out.println(Arrays.toString(twoSum(a, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i); //  key 为 差值， value 为 数组索引
        }
        return null;
    }
}
