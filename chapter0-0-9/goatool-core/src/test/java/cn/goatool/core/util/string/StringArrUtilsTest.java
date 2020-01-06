package cn.goatool.core.util.string;

import org.junit.Test;

import java.util.Properties;

import static cn.goatool.core.util.string.StringArrUtils.*;
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
    public void testTokenizeToStringArray() {
        String[] sa = tokenizeToStringArray("a,b , ,c", ",");
        assertEquals(3, sa.length);
        assertTrue("components are correct",sa[0].equals("a") && sa[1].equals("b") && sa[2].equals("c"));
    }


    @Test
    public void testTokenizeToStringArray1() {
        String[] sa = tokenizeToStringArray("a,b , ,c", ",", true, false);
        assertEquals(4, sa.length);
        assertTrue("components are correct",sa[0].equals("a") && sa[1].equals("b") && sa[2].equals("") && sa[3].equals("c"));
    }


    @Test
    public void testTokenizeToStringArray2() {
        String[] sa = tokenizeToStringArray("a,b , ,c", ",", true, true);
        assertEquals(3, sa.length);
        assertTrue("components are correct",sa[0].equals("a") && sa[1].equals("b")  && sa[2].equals("c"));
    }

    @Test
    public void testTokenizeToStringArray3() {
        String[] sa = tokenizeToStringArray("a,b ,c", ",", false, true);
        assertEquals(3, sa.length);
        assertTrue("components are correct",sa[0].equals("a") && sa[1].equals("b ") && sa[2].equals("c"));
    }

    @Test
    public void testSplitArrayElementsIntoProperties() {
        String[] input = new String[] {"key1=value1 ", "key2 =\"value2\""};
        Properties result = splitArrayElementsIntoProperties(input, "=");
        assertEquals("value1", result.getProperty("key1"));
        assertEquals("\"value2\"", result.getProperty("key2"));
    }

    @Test
    public void testSplitArrayElementsIntoPropertiesAndDeletedChars() {
        String[] input = new String[] {"key1=value1 ", "key2 =\"value2\""};
        Properties result = splitArrayElementsIntoProperties(input, "=", "\"");
        assertEquals("value1", result.getProperty("key1"));
        assertEquals("value2", result.getProperty("key2"));
    }
    
    @Test
    public void testSplit() {
        String[] res = split("goat: you good!", ": ");
        assertEquals("goat", res[0]);
        assertEquals("you good!", res[1]);
    }

    @Test
    public void testRemoveDuplicateStrings() {
        String[] input = new String[] {"myString2", "myString1", "myString2"};
        input = removeDuplicateStrings(input);
        assertEquals("myString2", input[0]);
        assertEquals("myString1", input[1]);
    }

    @Test
    public void testSortStringArray() {
        String[] input = new String[] {"myString2"};
        input = addStringToArray(input, "myString1");
        assertEquals("myString2", input[0]);
        assertEquals("myString1", input[1]);
    }


    @Test
    public void testConcatenateStringArrays() {
        String[] input1 = new String[] {"myString2"};
        String[] input2 = new String[] {"myString1", "myString2"};
        String[] result = concatenateStringArrays(input1, input2);
        assertEquals(3, result.length);
        assertEquals("myString2", result[0]);
        assertEquals("myString1", result[1]);
        assertEquals("myString2", result[2]);

        assertArrayEquals(input1, concatenateStringArrays(input1, null));
        assertArrayEquals(input2, concatenateStringArrays(null, input2));
        assertNull(concatenateStringArrays(null, null));
    }


    @Test
    public void testMergeStringArrays() {
        String[] input1 = new String[] {"myString2"};
        String[] input2 = new String[] {"myString1", "myString2"};
        String[] result = mergeStringArrays(input1, input2);
        assertEquals(2, result.length);
        assertEquals("myString2", result[0]);
        assertEquals("myString1", result[1]);

        assertArrayEquals(input1, mergeStringArrays(input1, null));
        assertArrayEquals(input2, mergeStringArrays(null, input2));
        assertNull(mergeStringArrays(null, null));
    }

}
