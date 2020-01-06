package cn.goatool.core.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2020/1/6.
 * @ Description: 字符串检测工具类 （源自spring）
 * @ author  山羊来了
 * @ date 2020/1/6---10:01
 */
public class StringCheckUtilTest {

    // 测试 空白
    @Test
    public void testHasTextBlank() {
        assertEquals(false, StringCheckUtil.hasText( "          "));
    }

    // 测试 空
    @Test
    public void testHasTextNullEmpty() {
        assertEquals(false, StringCheckUtil.hasText(null));
        assertEquals(false, StringCheckUtil.hasText(""));
    }

    // 测试 特殊符号
    @Test
    public void testHasTextValid() {
        assertEquals(false, StringCheckUtil.hasText("\t"));
        assertEquals(false, StringCheckUtil.hasText("\n"));
        assertEquals(true, StringCheckUtil.hasText("t"));
    }

    StringBuilder sb = new StringBuilder();

    // 测试  CharSequence 接口
    @Test
    public void testCharSequence1() {
        sb.append(" ");
        assertEquals(false, StringCheckUtil.hasText(sb));
    }

    @Test
    public void testCharSequence2() {
        sb.append(1);
        assertEquals(true, StringCheckUtil.hasText(sb));
    }

}
