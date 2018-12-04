package com.goat.lang3;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

/**
 * Created by 64274 on 2018/11/12.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/12---14:28
 */
public class MyStringUtils {


    /**
     * @Description: 清除掉str首尾的空白字符, 如果仅str全由空白字符组成则返回null
     * @author: 杨帆
     * @Param: " 11123 " ----->  "11123"
     * @Date: 2018/11/12
     */
    @Test
    public void trimToEmpty() {
        System.out.println(StringUtils.trimToEmpty(" 11123 "));
    }

    /**
     * @Description: 清除掉str首尾的空白字符, 如果仅str全由空白字符组成则返回null
     * @author: 杨帆
     * @Param: "1234" ----->  "4321"
     * @Date: 2018/11/12
     */
    @Test
    public void reverse() {
        System.out.println(StringUtils.reverse("1234"));
    }

    @Test
    public void capitalize() {
        System.out.println(StringUtils.capitalize("abc"));// 首字母大写
        System.out.println(StringUtils.uncapitalize("ABC"));// 首字母小写
    }

    /**
         * @Description:  isBlank isEmpty  isNotBlank isNotEmpty
         * @author: 杨帆
                            isNotEmpty(str)等价于 str != null && str.length > 0
                            isNotBlank(str) 等价于 str != null && str.length > 0 && str.trim().length > 0
                            isEmpty 等价于 str == null || str.length == 0
                            isBlank  等价于 str == null || str.length == 0 || str.trim().length == 0
                            str.length > 0 && str.trim().length > 0  --->   str.length > 0
         * @Date:   2018/12/4
    */
    @Test
    public void isBlank() {
        String test = ""; // true
        // String test = null; // true
        System.out.println(StringUtils.isBlank(test));
    }
    @Test
    public void isNotBlank() {
        String test = ""; // false
        // String test = null; // false
        System.out.println(StringUtils.isNotBlank(test));
    }
    @Test
    public void isNoneEmpty() {
        String test = ""; // false
        // String test = null; // false
        System.out.println(StringUtils.isNoneEmpty(test));
    }
}

