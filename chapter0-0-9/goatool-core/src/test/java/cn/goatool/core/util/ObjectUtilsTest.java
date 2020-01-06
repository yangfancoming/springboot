package cn.goatool.core.util;

import org.junit.Test;

import java.util.*;

import static cn.goatool.core.util.ObjectUtils.isEmpty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/6---11:14
 */
public class ObjectUtilsTest {


    // Object[] 参数的方法测试
    @Test
    public void isEmptyNull() {
        assertTrue(isEmpty(null));
    }

    @Test
    public void isEmptyArray1() {
        assertTrue(isEmpty(new Object[0]));
        assertTrue(isEmpty(new Integer[0]));
        assertFalse(isEmpty(new Integer[] {42}));
    }

    // Object 参数的方法测试
    @Test
    public void isEmptyArray2() {
        assertTrue(isEmpty(new char[0]));
        assertFalse(isEmpty(new int[] {42}));
    }

    @Test
    public void isEmptyCollection() {
        assertTrue(isEmpty(Collections.emptyList()));
        assertTrue(isEmpty(Collections.emptySet()));

        Set<String> set = new HashSet<>();
        set.add("foo");
        assertFalse(isEmpty(set));
        assertFalse(isEmpty(Arrays.asList("foo")));
    }

    @Test
    public void isEmptyMap() {
        assertTrue(isEmpty(Collections.emptyMap()));

        HashMap<String, Object> map = new HashMap<>();
        map.put("foo", 42L);
        assertFalse(isEmpty(map));
    }

    @Test
    public void isEmptyCharSequence() {
        assertTrue(isEmpty(new StringBuilder()));
        assertTrue(isEmpty(""));

        assertFalse(isEmpty(new StringBuilder("foo")));
        assertFalse(isEmpty("   "));
        assertFalse(isEmpty("\t"));
        assertFalse(isEmpty("foo"));
    }

    // 不支持类型的测试
    @Test
    public void isEmptyUnsupportedObjectType() {
        assertFalse(isEmpty(42L));
        assertFalse(isEmpty(new Object()));
    }
}
