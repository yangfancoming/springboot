package cn.goatool.core.util;

import com.sun.istack.internal.Nullable;

/**
 * Created by Administrator on 2020/1/6.
 * @ Description: 字符串检测工具类 （源自spring）
 * @ author  山羊来了
 * @ date 2020/1/6---9:59
 */
public class StringCheckUtil {

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
