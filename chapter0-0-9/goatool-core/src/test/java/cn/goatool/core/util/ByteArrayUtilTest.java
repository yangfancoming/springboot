package cn.goatool.core.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * 字节数据工具类测试
 * @ date 2019/12/4---16:40
 */
public class ByteArrayUtilTest extends TestData {

    @Test
    public void byteArrToHexString1() {
        String hexString = ByteArrayUtil.byteArrToHexString(primitiveArray);
        Assert.assertEquals("[38,03,00,00,00,05]", hexString);
    }

    @Test
    public void byteArrToHexStringUpperCase() {
        String hexString = ByteArrayUtil.byteArrToHexString(foo,true);
        Assert.assertEquals("[7E,09,0A]", hexString);
    }

    @Test
    public void byteArrToHexStringLowerCase() {
        String hexString = ByteArrayUtil.byteArrToHexString(foo,false);
        Assert.assertEquals("[7e,09,0a]", hexString);
    }

    @Test
    public void convertToPrimitiveArray() {
        byte[] bytes = ByteArrayUtil.convertToPrimitiveArray(objectArray);
        String hexString = ByteArrayUtil.byteArrToHexString(bytes);
        Assert.assertEquals("[02,05,00,03,FF,00]", hexString);
    }

    @Test
    public void convertToPrimitiveAr1ray() {
        Byte[] bytes = ByteArrayUtil.convertToObjectArray(primitiveArray);
        Assert.assertNotNull(bytes);
    }

    @Test
    public void byteArrToShort() {
        byte[] bytes = new byte[]{0x00,0x09};
        short s = ByteArrayUtil.byteArrToShort(bytes);
        Assert.assertEquals(9, s);
    }
    /**
     *      * @Param:      byte[] hoho1 = MyArrayTool.reverseArray(byteArrs);
     *      * @Return:   20,27,3,18,22,14,1,2

    */
    @Test
    public void reverseArray() {
        byte[] bytes = {2, 1, 14, 22, 18, 3, 27, 20};
        byte[] s = ByteArrayUtil.reverseArray(bytes);
        System.out.println(new String(s));
    }
}
