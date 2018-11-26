package utils;

import jp.sourceforge.qrcode.QRCodeDecoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * Created by 64274 on 2018/11/26.
 *
 * @author 山羊来了
 * @Description: 二维码 解码
 * @date 2018/11/26---20:28
 */
public class ReadQRCode {
    public  void test() throws IOException {
        //图片路径   如果路径错误或是没有对应文件 则报错：  javax.imageio.IIOException: Can't read input file!
        String basepath= URLDecoder.decode("D:\\qrcode.png","utf-8");//这样就能解决掉那个空格的问题了。
        File file = new File(basepath);
        //读取图片到缓冲区
        BufferedImage bufferedImage = ImageIO.read(file);
        //QRCode解码器
        QRCodeDecoder codeDecoder = new QRCodeDecoder();
        /**
         *codeDecoder.decode(new MyQRCodeImage())
         *这里需要实现QRCodeImage接口，移步最后一段代码
         */
        //通过解析二维码获得信息
        String result = new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)), "utf-8");
        System.out.println(result);
    }
}