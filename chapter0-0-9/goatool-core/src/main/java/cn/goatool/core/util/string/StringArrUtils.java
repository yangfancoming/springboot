package cn.goatool.core.util.string;

import cn.goatool.core.util.ObjectUtils;
import com.sun.istack.internal.Nullable;

import java.util.*;

import static cn.goatool.core.util.string.StringCheckUtils.hasLength;

/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: 字符串数组工具类（使用字符串数组的方便方法）
 * @ author  山羊来了
 * @ date 2020/1/6---10:58
 */
public class StringArrUtils {


    /**
     * 删除字符串中指定的字符
     * @param inString 待操作的字符串
     * @param charsToDelete 要删除的字符集合
     * eg:	StringUtils.deleteAny("Able was I ere I saw Elba", "I") ===> "Able was  ere  saw Elba"
     */
    public static String deleteAny(String inString, @Nullable String charsToDelete) {
        if (!hasLength(inString) || !hasLength(charsToDelete)) {
            return inString;
        }
        StringBuilder sb = new StringBuilder(inString.length());
        for (int i = 0; i < inString.length(); i++) {
            char c = inString.charAt(i);
            if (charsToDelete.indexOf(c) == -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 干掉字符串数组中的重复元素
     * 由于使用了 LinkedHashSet 数组保留其原始顺序
     * @param array  待去重数组
     * @return 去重后的数组，数组元素顺序不变
     */
    public static String[] removeDuplicateStrings(String[] array) {
        if (ObjectUtils.isEmpty(array)) {
            return array;
        }
        Set<String> set = new LinkedHashSet<>(Arrays.asList(array));
        return toStringArray(set);
    }

    /**
     * 将指定字符串添加到指定数组中
     * 返回一个新的数组 包含指定数组内容外加指定字符串
     * @param array  添加到的目标数组
     * @param str  待添加的字符串
     */
    public static String[] addStringToArray(@Nullable String[] array, String str) {
        if (ObjectUtils.isEmpty(array)) {
            return new String[] {str};
        }
        String[] newArr = new String[array.length + 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[array.length] = str;
        return newArr;
    }

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

    /**
     * 数组合并
     * 将给定的两个数组 合并成一个，两个数组中重叠/相同的元素 只保留第一次出现的元素
     * 原始数组中元素顺序保持不变
     * @param array1 第一个数组 (原数组)
     * @param array2 第二个数组
     */
    @Nullable
    public static String[] mergeStringArrays(@Nullable String[] array1, @Nullable String[] array2) {
        if (ObjectUtils.isEmpty(array1)) {
            return array2;
        }
        if (ObjectUtils.isEmpty(array2)) {
            return array1;
        }

        List<String> result = new ArrayList<>();
        result.addAll(Arrays.asList(array1));
        for (String str : array2) {
            if (!result.contains(str)) {
                result.add(str);
            }
        }
        return toStringArray(result);
    }

    /**
     * Copy the given {@link Collection} into a {@code String} array.
     * The {@code Collection} must contain {@code String} elements only.
     * @param collection the {@code Collection} to copy (potentially {@code null} or empty)
     * @return the resulting {@code String} array
     */
    public static String[] toStringArray(@Nullable Collection<String> collection) {
        return (collection != null ? collection.toArray(new String[0]) : new String[0]);
    }

}
