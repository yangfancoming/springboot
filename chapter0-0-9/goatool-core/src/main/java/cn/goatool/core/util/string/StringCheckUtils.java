package cn.goatool.core.util.string;

import com.sun.istack.internal.Nullable;

/**
 * Created by Administrator on 2020/1/6.
 * @ Description: 字符串校检工具类 （源自spring）
 * @ author  山羊来了
 * @ date 2020/1/6---9:59
 */
public class StringCheckUtils {

    /**
     * @Description:  干掉指定字符串头尾的空白符  该功能比jdk内置的 str.trim() 优势的是可以输入null 其他功能都一样
     * @param str 待检测的字符串
     * @author goat
     * @date 2020年1月6日10:29:20
     */
    public static String trimWhitespace(String str) {
        if (!hasLength(str)) {
            return str;
        }
        int beginIndex = 0;
        int endIndex = str.length() - 1;
        while (beginIndex <= endIndex && Character.isWhitespace(str.charAt(beginIndex))) {
            beginIndex++;
        }
        while (endIndex > beginIndex && Character.isWhitespace(str.charAt(endIndex))) {
            endIndex--;
        }
        return str.substring(beginIndex, endIndex + 1);
    }

    /**
     * @Description: 检测指定字符串，是否包含空白符
     * @param str 待检测的字符串
     * @author goat
     * @return {@code true} if the {@code CharSequence} is not empty and contains at least 1 whitespace character
     * @return 只有在输入字符串 不为null或empty  且至少有一个空白符才返回true
     * @date 2020年1月6日10:29:20
     */
    public static boolean containsWhitespace(@Nullable CharSequence str) {
        if (!hasLength(str)) {
            return false;
        }

        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsWhitespace(@Nullable String str) {
        return containsWhitespace((CharSequence) str);
    }

    /**
     * @Description: 检测指定字符串，是否为null或长度为0
     * @param str 待检测的字符串
     * StringUtils.hasLength(null) = false
     * StringUtils.hasLength("") = false
     * StringUtils.hasLength(" ") = true
     * StringUtils.hasLength("Hello") = true
     * @author goat
     * @date 2020年1月6日10:29:20
     */
    public static boolean hasLength(@Nullable String str) {
        return (str != null && !str.isEmpty());
    }

    public static boolean hasLength(@Nullable CharSequence str) {
        return (str != null && str.length() > 0);
    }


    /**
     * @Description: 检测指定字符串，是否包含实际内容  （str不为null 且长度大于0 且 包含非空白字符 才返回true）
     * @param str 待检测的字符串
     *         assertEquals(false, StringCheckUtil.hasText("\t"));
     *         assertEquals(false, StringCheckUtil.hasText("\n"));
     *         assertEquals(true, StringCheckUtil.hasText("t"));
     *         assertEquals(false, StringCheckUtil.hasText(null));
     *         assertEquals(false, StringCheckUtil.hasText(""));
     * @author goat
     * @date 2020年1月6日10:11:17
     */
    public static boolean hasText(@Nullable String str) {
        return (str != null && !str.isEmpty() && containsText(str));
    }

    /**
     * @Description:  同上，只是检测的不是字符串  而是实现 CharSequence 接口的类 eg:StringBuilder
     * @param str 待检测的字符串
     *             StringBuilder sb = new StringBuilder();
     *             assertEquals(false, StringCheckUtil.hasText(sb));
     * @author goat
     * @date 2020年1月6日10:11:17
     */
    public static boolean hasText(@Nullable CharSequence str) {
        return (str != null && str.length() > 0 && containsText(str));
    }

    private static boolean containsText(CharSequence str) {
        int strLen = str.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
