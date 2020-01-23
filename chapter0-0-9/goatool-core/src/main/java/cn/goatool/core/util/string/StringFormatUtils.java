package cn.goatool.core.util.string;

import com.sun.istack.internal.Nullable;

import java.text.DecimalFormat;

import static cn.goatool.core.util.string.StringCheckUtils.hasLength;

/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: 格式化字符串 工具类
 * @ author  山羊来了
 * @ date 2020/1/6---13:57
 */
public class StringFormatUtils {

    private static final String FOLDER_SEPARATOR = "/";

    private static final char EXTENSION_SEPARATOR = '.';


    /**
     * @Description: 功能描述： 格式填充（左侧）
     * @author: Goat
     * @param mark  填充标记   (使用什么内容填充)
     * @param count 填充后的总长度
     * @param num 待填充内容
     * @Date:   2019年6月12日16:19:19
     */
    public static String fill(String mark,Integer count,Integer num){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(mark);
        }
        return new DecimalFormat(sb.toString()).format(num);
    }

    /**
     * 从给定的Java资源路径中删除文件后缀名
     * e.g. "mypath/myfile.txt" -> "mypath/myfile".
     * @param path 资源路径
     */
    public static String stripFilenameExtension(String path) {
        int extIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
        if (extIndex == -1) {
            return path;
        }

        int folderIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        if (folderIndex > extIndex) {
            return path;
        }

        return path.substring(0, extIndex);
    }
    /**
     * 从给定的Java资源路径中提取文件名后缀名
     * e.g. "mypath/myfile.txt" -> "txt".
     * @param path 资源路径
     */
    @Nullable
    public static String getFilenameExtension(@Nullable String path) {
        if (path == null) {
            return null;
        }
        int extIndex = path.lastIndexOf(EXTENSION_SEPARATOR);
        if (extIndex == -1) {
            return null;
        }
        int folderIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        if (folderIndex > extIndex) {
            return null;
        }
        return path.substring(extIndex + 1);
    }



    /**
     * 从给定的Java资源路径中提取文件名
     * e.g. {@code "mypath/myfile.txt" -> "myfile.txt"}.
     * @param path 资源路径
     * @return  提取的文件名
     */
    @Nullable
    public static String getFilename(@Nullable String path) {
        if (path == null) {
            return null;
        }
        int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
        return (separatorIndex != -1 ? path.substring(separatorIndex + 1) : path);
    }

    /**
     * 将指定字符串的首字母大写  其他字母不变
     * @param str 待处理的字符串
     */
    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    /**
     * 将指定字符串的首字母小写  其他字母不变
     * @param str 待处理的字符串
     */
    public static String uncapitalize(String str) {
        return changeFirstCharacterCase(str, false);
    }

    /**
     * 将指定字符串的首字母大/小写  其他字母不变
     * @param str 待处理的字符串
     * @param capitalize true 转大写  false转小写
     */
    private static String changeFirstCharacterCase(String str, boolean capitalize) {
        if (!hasLength(str)) {
            return str;
        }
        char baseChar = str.charAt(0);
        char updatedChar = capitalize ? Character.toUpperCase(baseChar):Character.toLowerCase(baseChar);
        if (baseChar == updatedChar) {
            return str;
        }
        char[] chars = str.toCharArray();
        chars[0] = updatedChar;
        return new String(chars, 0, chars.length);
    }

    /**
     * 按照指定字符 取消字符串的限定名  默认字符为  '.'
     * "this.name.is.qualified", returns "qualified".
     * @param qualifiedName 待取消的限定名
     */
    public static String unqualify(String qualifiedName) {
        return unqualify(qualifiedName, '.');
    }

    /**
     * 按照指定字符 取消字符串的限定名
     * For example,"this:name:is:qualified" returns "qualified" if using a ':' separator.
     * @param qualifiedName 待取消的限定名
     * @param separator 指定限定名字符
     */
    public static String unqualify(String qualifiedName, char separator) {
        return qualifiedName.substring(qualifiedName.lastIndexOf(separator) + 1);
    }

    /**
     * 将指定对象转换成字符串对象 如果转换成功则添加单引号，否则保持原样
     * @param obj 待操作的对象
     */
    @Nullable
    public static Object quoteIfString(@Nullable Object obj) {
        return (obj instanceof String ? quote((String) obj) : obj);
    }

    /**
     *  给指定字符串增加单引号
     * @param str 待操作的字符串
     */
    @Nullable
    public static String quote(@Nullable String str) {
        return (str != null ? "'" + str + "'" : null);
    }
}
