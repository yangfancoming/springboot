package cn.goatool.core.util.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2020/1/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/6---11:29
 */
public class StringArrUtilsTest {

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
    public void testRemoveDuplicateStrings() {
        String[] input = new String[] {"myString2", "myString1", "myString2"};
        input = StringArrUtils.removeDuplicateStrings(input);
        assertEquals("myString2", input[0]);
        assertEquals("myString1", input[1]);
    }

    @Test
    public void testSortStringArray() {
        String[] input = new String[] {"myString2"};
        input = StringArrUtils.addStringToArray(input, "myString1");
        assertEquals("myString2", input[0]);
        assertEquals("myString1", input[1]);
    }


    @Test
    public void testConcatenateStringArrays() {
        String[] input1 = new String[] {"myString2"};
        String[] input2 = new String[] {"myString1", "myString2"};
        String[] result = StringArrUtils.concatenateStringArrays(input1, input2);
        assertEquals(3, result.length);
        assertEquals("myString2", result[0]);
        assertEquals("myString1", result[1]);
        assertEquals("myString2", result[2]);

        assertArrayEquals(input1, StringArrUtils.concatenateStringArrays(input1, null));
        assertArrayEquals(input2, StringArrUtils.concatenateStringArrays(null, input2));
        assertNull(StringArrUtils.concatenateStringArrays(null, null));
    }


    @Test
    @Deprecated
    public void testMergeStringArrays() {
        String[] input1 = new String[] {"myString2"};
        String[] input2 = new String[] {"myString1", "myString2"};
        String[] result = StringArrUtils.mergeStringArrays(input1, input2);
        assertEquals(2, result.length);
        assertEquals("myString2", result[0]);
        assertEquals("myString1", result[1]);

        assertArrayEquals(input1, StringArrUtils.mergeStringArrays(input1, null));
        assertArrayEquals(input2, StringArrUtils.mergeStringArrays(null, input2));
        assertNull(StringArrUtils.mergeStringArrays(null, null));
    }

}
