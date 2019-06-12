package com.goat.lang3;

import org.junit.Test;

import java.text.DecimalFormat;


/**
 * Created by 64274 on 2019/6/12.
 *
 * @ Description: 自己的字符串 工具类
 * @ author  山羊来了
 * @ date 2019/6/12---15:38
 */
public class MyStrUtil {


    @Test
    public void test(){
        // 用 0 填充  填充后总长度为4位  待填充内容  ==
        String haha = haha("0", 4, 1);
        System.out.println(haha); // 0001
    }
    /**
     * @Description: 功能描述： 格式填充
     * @author: Goat
     * @Param: mark  填充标记   (使用什么内容填充)
     * @Param: count 填充后的总长度
     * @Param: num   待填充内容
     * @Return:
     * @Date:   2019年6月12日16:19:19
     */

    public String haha(String mark,Integer count,Integer num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
           sb.append(mark);
        }
        return new DecimalFormat("0000").format(num);
    }
}
