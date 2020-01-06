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

}
