package cn.goatool.core.util.string;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2020/1/6.
 * @ Description: 字符串检测工具类 （源自spring）
 * @ author  山羊来了
 * @ date 2020/1/6---10:01
 */
public class StringCheckUtilsTest {

    // 测试 空白
    @Test
    public void testBlank() {
        assertEquals(false, StringCheckUtils.hasText( "          "));

        assertEquals(true, StringCheckUtils.hasLength( "          "));
    }

    // 测试 空
    @Test
    public void testNullEmpty() {
        assertEquals(false, StringCheckUtils.hasText(null));
        assertEquals(false, StringCheckUtils.hasText(""));

        assertEquals(false, StringCheckUtils.hasLength(null));
        assertEquals(false, StringCheckUtils.hasLength(""));
    }

    // 测试 特殊符号
    @Test
    public void testValid() {
        assertEquals(false, StringCheckUtils.hasText("\t"));
        assertEquals(false, StringCheckUtils.hasText("\n"));
        assertEquals(true, StringCheckUtils.hasText("t"));

        assertEquals(true, StringCheckUtils.hasLength("\t"));
        assertEquals(true, StringCheckUtils.hasLength("\n"));
        assertEquals(true, StringCheckUtils.hasLength("t"));
    }

    StringBuilder sb = new StringBuilder();

    // 测试  CharSequence 接口
    @Test
    public void testCharSequence1() {
        sb.append(" ");
        assertEquals(false, StringCheckUtils.hasText(sb));

        assertEquals(true, StringCheckUtils.hasLength(sb));
    }

    @Test
    public void testCharSequence2() {
        sb.append(1);
        assertEquals(true, StringCheckUtils.hasText(sb));

        assertEquals(true, StringCheckUtils.hasLength(sb));
    }


    @Test
    public void testContainsWhitespace() {
        // 无空白符测试
        assertFalse(StringCheckUtils.containsWhitespace(null));
        assertFalse(StringCheckUtils.containsWhitespace(""));
        assertFalse(StringCheckUtils.containsWhitespace("a"));
        assertFalse(StringCheckUtils.containsWhitespace("abc"));
        // 有空白符测试
        assertTrue(StringCheckUtils.containsWhitespace(" "));
        assertTrue(StringCheckUtils.containsWhitespace(" a"));
        assertTrue(StringCheckUtils.containsWhitespace("abc "));
        assertTrue(StringCheckUtils.containsWhitespace("a b"));
        assertTrue(StringCheckUtils.containsWhitespace("a  b"));
    }

    @Test
    public void testTrimWhitespace() {
        assertEquals(null, StringCheckUtils.trimWhitespace(null));
        assertEquals("", StringCheckUtils.trimWhitespace(""));
        assertEquals("", StringCheckUtils.trimWhitespace(" "));
        assertEquals("", StringCheckUtils.trimWhitespace("\t"));
        assertEquals("a", StringCheckUtils.trimWhitespace(" a"));
        assertEquals("a", StringCheckUtils.trimWhitespace("a "));
        assertEquals("a", StringCheckUtils.trimWhitespace(" a "));
        assertEquals("a b", StringCheckUtils.trimWhitespace(" a b "));
        assertEquals("a b  c", StringCheckUtils.trimWhitespace(" a b  c "));


        // jdk 内置的 trim()
        assertEquals("", "".trim());
        assertEquals("", " ".trim());
        assertEquals("", "\t".trim());
        assertEquals("a", " a".trim());
        assertEquals("a", "a ".trim());
        assertEquals("a b", " a b ".trim());
        assertEquals("a b  c", " a b  c ".trim());
    }

}
