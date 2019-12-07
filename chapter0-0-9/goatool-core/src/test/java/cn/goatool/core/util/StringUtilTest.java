package cn.goatool.core.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 字符串工具类 测试
 * @ date 2019/12/4---17:37
 *
 *      * 输入示例：   MyStringTool.StrSplit("1234567890",3);
 *      * 输出结果：   123,456,789
 */
public class StringUtilTest {

    @Test
    public void intToAsc(){
        String s = StringUtil.intToAsc("1234");
        Assert.assertEquals("[31,32,33,34]", s);
    }

    @Test
    public void StrSplit(){
        String[] arr = StringUtil.StrSplit("1234567890",3);
        Assert.assertEquals("[123, 456, 789]", Arrays.toString(arr));
    }

    @Test
    public void strReverse(){
        String s = StringUtil.strReverse("1234567890",2);
        Assert.assertEquals("9078563412", s);

        String s1 = StringUtil.strReverse("1234567890",5);
        Assert.assertEquals("6789012345", s1);
    }

    @Test
    public void hex2bytes(){
        byte[] s = StringUtil.hex2bytes("7B01");
        Assert.assertEquals(2, s.length);
    }

}
