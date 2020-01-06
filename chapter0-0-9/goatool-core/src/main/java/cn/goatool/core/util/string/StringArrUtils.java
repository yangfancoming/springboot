package cn.goatool.core.util.string;

import cn.goatool.core.util.ObjectUtils;
import com.sun.istack.internal.Nullable;

/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: 字符串数据工具类
 * @ author  山羊来了
 * @ date 2020/1/6---10:58
 */
public class StringArrUtils {


    /**
     * 数组拼接
     * 将给定的两个数组 拼接成一个，两个数组中重叠/相同的元素包含两次(不覆盖)
     * 原始数组中元素顺序保持不变
     * @param array1 第一个数组 (原数组)
     * @param array2 第二个数组
     */
    @Nullable
    public static String[] concatenateStringArrays(@Nullable String[] array1, @Nullable String[] array2) {
        if (ObjectUtils.isEmpty(array1)) {
            return array2;
        }
        if (ObjectUtils.isEmpty(array2)) {
            return array1;
        }

        String[] newArr = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, newArr, 0, array1.length);
        System.arraycopy(array2, 0, newArr, array1.length, array2.length);
        return newArr;
    }
}
