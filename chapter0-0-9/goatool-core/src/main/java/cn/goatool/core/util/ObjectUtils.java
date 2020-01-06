package cn.goatool.core.util;

import com.sun.istack.internal.Nullable;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/6---11:10
 */
public class ObjectUtils {

    /**
     * @Description: 校检指定数组是否为 empty  (null 或 长度为0)
     * @param array 待校检的数组
     * @author goat
     * @date 2020年1月6日11:12:15
     */
    public static boolean isEmpty(@Nullable Object[] array) {
        return (array == null || array.length == 0);
    }



    /**
     * @Description: 校检指定 对象 是否为 empty  (null 或 长度为0)
     * 此方法支持的校检类型： Optional Array  CharSequence Collection Map
     * @param obj 待校检的对象
     * @author goat
     * @date 2020年1月6日11:20:06
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(@Nullable Object obj) {
        if (obj == null) {
            return true;
        }

        if (obj instanceof Optional) {
            return !((Optional) obj).isPresent();
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        // else
        return false;
    }

}
