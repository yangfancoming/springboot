package com.goat.core.util;



/**
 * 数组工具类
 * 
 * @author Looly
 *
 */
public class ArrayUtil {

	/** 数组中元素未找到的下标，值为-1 */
	public static final int INDEX_NOT_FOUND = -1;

	// ---------------------------------------------------------------------- isEmpty
	/**
	 * 数组是否为空
	 * 
	 * @param <T> 数组元素类型
	 * @param array 数组
	 * @return 是否为空
	 */
//	@SuppressWarnings("unchecked")
	public static <T> boolean isEmpty(final T... array) {
		return array == null || array.length == 0;
	}

//    public static boolean isEmpty(final int... array) {
//        return array == null || array.length == 0;
//    }


}
