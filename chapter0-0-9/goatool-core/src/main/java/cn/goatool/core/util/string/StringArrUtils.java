package cn.goatool.core.util.string;

import cn.goatool.core.util.ObjectUtils;
import com.sun.istack.internal.Nullable;

import java.util.*;

import static cn.goatool.core.util.string.StringCheckUtils.hasLength;
import static cn.goatool.core.util.string.StringUtils.deleteAny;


/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: 字符串数组工具类（使用字符串数组的方便方法）
 * @ author  山羊来了
 * @ date 2020/1/6---10:58
 */
public class StringArrUtils {


    public static String[] tokenizeToStringArray(@Nullable String str, String delimiters) {
        return tokenizeToStringArray(str, delimiters, true, true);
    }

    /**
     * 通过jdk StringTokenizer 对象将 给定字符串 标记化成字符串数组
     * 给定的分隔符字符串可以由任意数量的分隔符字符组成。
     * 每个字符都可以用来做分隔符
     * 分隔符始终是单个字符；对于多字符分隔符，使用多个字符可以使用 {@link #delimitedListToStringArray}.
     * @param str 待标记化的字符串
     * @param delimiters 分隔符 （每个字符都被单独视为分隔符）
     * @param trimTokens trim the tokens via {@link String#trim()}
     * @param ignoreEmptyTokens 从结果数组中省略空标记
     */
    public static String[] tokenizeToStringArray(@Nullable String str, String delimiters, boolean trimTokens, boolean ignoreEmptyTokens) {
        if (str == null) {
            return new String[0];
        }
        StringTokenizer st = new StringTokenizer(str, delimiters);
        List<String> tokens = new ArrayList<>();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (trimTokens) {
                token = token.trim();
            }
            if (!ignoreEmptyTokens || token.length() > 0) {
                tokens.add(token);
            }
        }
        return toStringArray(tokens);
    }

    @Nullable
    public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter) {
        return splitArrayElementsIntoProperties(array, delimiter, null);
    }

    /**
     * 将一个字符串数组 按照指定分隔符 进行分隔 并将分隔符左右两侧的内容分别作为key和value 保存到 Properties 对象中
     * @param array 待处理的字符串数组
     * @param delimiter  指定分隔符
     * @param charsToDelete 需要删除的字符
     */
    @Nullable
    public static Properties splitArrayElementsIntoProperties(String[] array, String delimiter, @Nullable String charsToDelete) {
        if (ObjectUtils.isEmpty(array)) {
            return null;
        }
        Properties result = new Properties();
        for (String element : array) {
            if (charsToDelete != null) {
                element = deleteAny(element, charsToDelete);
            }
            String[] splittedElement = split(element, delimiter);
            if (splittedElement == null) {
                continue;
            }
            result.setProperty(splittedElement[0].trim(), splittedElement[1].trim());
        }
        return result;
    }

    /**
     * 在分隔符第一次出现时拆分字符串，分隔结果不包含分隔符
     * @param toSplit  待分隔的字符串
     * @param delimiter 指定分隔符
     * @return 返回一个包含2个元素的字符串数组  元素1 为分隔符之前的内容  元素2为分隔符之后的内容
     * 如果没有匹配到分隔符 则返回 null
     */
    @Nullable
    public static String[] split(@Nullable String toSplit, @Nullable String delimiter) {
        if (!hasLength(toSplit) || !hasLength(delimiter)) {
            return null;
        }
        int offset = toSplit.indexOf(delimiter);
        if (offset < 0) {
            return null;
        }
        String beforeDelimiter = toSplit.substring(0, offset);
        String afterDelimiter = toSplit.substring(offset + delimiter.length());
        return new String[] {beforeDelimiter, afterDelimiter};
    }

    /**
     * @Description: 将字符串按照指定长度进行分割
     * @param str 待转换的字符串
     * 输入示例：   MyStringTool.StrSplit("1234567890",3);
     * 输出结果：   123,456,789
     * @author goat
     * @date 2018/7/11
     */
    public static String[] StrSplit(String str, int len){
        int length = str.length() / len;
        String[] shcuy = new String[length];
        for (int i = 0; i < length; i++){
            shcuy[i] = str.substring(0,len);
            str = str.substring(len);
        }
        return shcuy;
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
