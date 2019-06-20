package com.goat.core.util;

/**
 * 数组工具类
 */
public class ArrayUtil {

    /** 数组中元素未找到的下标，值为-1 */
    public static final int INDEX_NOT_FOUND = -1;

    // ---------------------------------------------------------------------- isEmpty
    /**
     * 判断数组是否为空
     *
     * @param <T> 数组元素类型(包装类型)
     * @param array 数组
     * @return 空=true  非空=false
     * sos 注意这里 最好别使用 变长参数作为形参 isEmpty(final T... array)  可以参考 搜索串：变长参数中的大坑
     */
    public static <T> boolean isEmpty(final T[] array) {
        return array == null || array.length == 0;
    }


    /**
     * 判断数组是否为空  以下为8种 基本类型重载
     *
     * @param array 数组
     * @return 是否为空
     */
    public static boolean isEmpty(final long... array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final int... array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final short... array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final char... array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final byte... array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final double... array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final float... array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmpty(final boolean... array) {
        return array == null || array.length == 0;
    }


}
