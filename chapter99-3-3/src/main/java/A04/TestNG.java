package A04;

import org.testng.annotations.Test;

/**
     * @Description: 功能描述： 3.4.1 基本数据类型
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/3
*/

public class TestNG {

    // 取出 各种数据类型的 极限值范围
    @Test
    public void test(){
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);

        System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);

        System.out.println("Float.MIN_VALUE = " + Float.MIN_VALUE);
        System.out.println("Float.MIN_NORMAL = " + Float.MIN_NORMAL);
        System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);

        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
    }
    //  面试题： 问 存在 i+1<i 这样的数吗？ （i-1>i 同理）
    @Test
    public void test1(){
        int i = 2147483647; // int类型的最大值  加1后 将变成 负数
        if (i+1<i){
            System.out.println("答：存在的");
        }else {
            System.out.println("答：不存在的");
        }

    }
}

