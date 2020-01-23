package cn.goatool.core.util.string;

import cn.goatool.core.util.ByteArrayUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * 字符串工具类 测试
 * @ date 2019/12/4---17:37
 *
 * 输入示例：   MyStringTool.StrSplit("1234567890",3);
 * 输出结果：   123,456,789
 */
public class StringUtilsTest {

    @Test
    public void testDeleteAny() {
        String inString = "Able was I ere I saw Elba";

        String res = StringUtils.deleteAny(inString, "I");
        assertTrue("Result has no Is [" + res + "]", res.equals("Able was  ere  saw Elba"));


        // 删除字符串中的所有出现的字符
        res = StringUtils.deleteAny(inString, "AeEba!");
        assertTrue("Result has no Is [" + res + "]", res.equals("l ws I r I sw l"));


        // 区分大小写
        res = StringUtils.deleteAny(inString, "A!");
        assertTrue("Result has no Is [" + res + "]", res.equals("ble was I ere I saw Elba"));

        String mismatch = StringUtils.deleteAny(inString, "#@$#$^");
        assertTrue("Result is unchanged", mismatch.equals(inString));

        //  测试 特殊字符
        String whitespace = "This is\n\n\n    \t   a messagy string with whitespace\n";
        assertTrue("Has CR", whitespace.contains("\n"));
        assertTrue("Has tab", whitespace.contains("\t"));
        assertTrue("Has  sp", whitespace.contains(" "));
        String cleaned = StringUtils.deleteAny(whitespace, "\n\t ");
        assertTrue("Has no CR", !cleaned.contains("\n"));
        assertTrue("Has no tab", !cleaned.contains("\t"));
        assertTrue("Has no sp", !cleaned.contains(" "));
        assertTrue("Still has chars", cleaned.length() > 10);
    }

    @Test
    public void intToAsc(){
        String s = StringUtils.intToAsc("1234");
        Assert.assertEquals("[31,32,33,34]", s);
    }

    @Test
    public void StrSplit(){
        String[] arr = StringArrUtils.StrSplit("1234567890",3);
        Assert.assertEquals("[123, 456, 789]", Arrays.toString(arr));
    }

    @Test
    public void strReverse(){
        String s = StringUtils.strReverse("1234567890",2);
        Assert.assertEquals("9078563412", s);

        String s1 = StringUtils.strReverse("1234567890",5);
        Assert.assertEquals("6789012345", s1);
    }

    @Test
    public void hex2bytes(){
        byte[] s = ByteArrayUtils.hex2bytes("7B01");
        Assert.assertEquals(2, s.length);
    }

}
