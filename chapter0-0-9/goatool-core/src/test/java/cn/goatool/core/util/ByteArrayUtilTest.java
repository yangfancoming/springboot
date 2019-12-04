package cn.goatool.core.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2019/12/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/4---16:40
 */
public class ByteArrayUtilTest extends TestData {

    @Test
    public void byteArrToHexString() {
        String hexString = ByteArrayUtil.byteArrToHexString(primitiveArray);
        Assert.assertEquals("[38,03,00,00,00,05]", hexString);
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
}
