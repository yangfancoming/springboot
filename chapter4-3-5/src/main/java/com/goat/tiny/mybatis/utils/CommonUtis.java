
package com.goat.tiny.mybatis.utils;


import java.util.Collection;
import java.util.Map;


/** 工具类 */
public final class CommonUtis {


    /** string is not empty */
    public static boolean isNotEmpty(String src){
        return src != null && src.trim().length() > 0;
    }

    /** list/set is not empty */
    public static boolean isNotEmpty(Collection<?> collection){
        return collection != null && !collection.isEmpty();
    }

    /** map is not empty */
    public static boolean isNotEmpty(Map<?, ?> map){
        return map != null && !map.isEmpty();
    }

    /** 数组不为空 */
    public static boolean isNotEmpty(Object[] arr){
        return arr != null && arr.length > 0;
    }

    /** 对字符串去空白符和换行符等 */
    public static String stringTrim(String src){
        return (null != src) ? src.trim() : null;
    }
}
