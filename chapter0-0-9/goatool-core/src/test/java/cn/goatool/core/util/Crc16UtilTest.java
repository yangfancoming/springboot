package cn.goatool.core.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2019/12/4.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/4---15:56
 */
public class Crc16UtilTest {

    byte[] test1 = {0x38,0x03,0x00,0x00,0x00,0x05};

    byte[] test2 = {0x02,0x05,0x00,0x03,(byte) 0xFF,0x00};


    @Test
    public void test() {
        int crc = Crc16Util.calcCrc16(test1);
        String crc16Str = String.format("%04x", crc);
        Assert.assertEquals("a080", crc16Str);
        String reverse = crc16Str.substring(2) + crc16Str.substring(0, 2);
        Assert.assertEquals("80a0", reverse);
    }

    @Test
    public void test1()   {
        int crc = Crc16Util.calcCrc16(test2);
        String crc16Str = String.format("%04x", crc);
        Assert.assertEquals("097c", crc16Str);
        String reverse = crc16Str.substring(2) + crc16Str.substring(0, 2);
        Assert.assertEquals("7c09", reverse);
    }
}
