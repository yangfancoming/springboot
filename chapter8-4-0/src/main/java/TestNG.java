import org.testng.annotations.Test;
import utils.QrcodeUtil;
import utils.ReadQRCode;

import java.io.IOException;


public class TestNG  {


    @Test
    public void test0() throws IOException {
        QrcodeUtil qrcodeUtil = new QrcodeUtil();
        qrcodeUtil.encodeQRcode("hello","src/222.png","png",10);
    }

    @Test
    public void test() throws IOException {
        ReadQRCode readQRCode = new ReadQRCode();
        readQRCode.test();
    }


}
