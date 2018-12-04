package com.goat;

import com.goat.utils.QRCodeUtil;
import com.google.common.collect.Maps;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import org.testng.annotations.Test;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class TestNG {


    /**
         * @Description: 生成带 Logo 二维码
         * @author: 杨帆
         * @Param:
         * @Return:
         * @Date:   2018/11/26
    */
    @Test
    public void test0() throws IOException, WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType,Object> hints  = Maps.newHashMap();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");//中文编码
        hints.put(EncodeHintType.MARGIN,2);//中心扫码区域距离边距 空白区域
        BitMatrix bitMatrix = qrCodeWriter.encode("http://www.baidu.com" , BarcodeFormat.QR_CODE,400,400,hints);
        //onColor 为 二维码颜色
        MatrixToImageConfig config = new MatrixToImageConfig(-88888,-1);

        //向二维码中添加Logo
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix, config);
        Graphics2D g = image.createGraphics();
        BufferedImage localImg = ImageIO.read(new File("./src/main/resources/1.jpg"));
        int widthLogo = localImg.getWidth(), heightLogo = localImg.getHeight();
        int x = (image.getWidth() - widthLogo) / 2;
        int y = (image.getHeight() - heightLogo) / 2;
        g.drawImage(localImg, x, y, widthLogo, heightLogo, null);
        g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
        g.setStroke(new BasicStroke(5));
        g.drawRect(x, y, widthLogo, heightLogo);
        g.dispose();
        ImageIO.write(image,"png",new File("src/123.png"));
    }


    // 解码 失败
    @Test
    public void test() {
        try {
            MultiFormatReader formatReader = new MultiFormatReader();
            File file = new File("src/123.png");
            if (file.exists()) {
                BufferedImage image = ImageIO.read(file);
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                Binarizer binarizer = new HybridBinarizer(source);
                BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
                Map hints = new HashMap();
                hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
                Result result = formatReader.decode(binaryBitmap, hints);
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
         * @Description:   生成带 Logo 二维码
         * @author: 杨帆
         * @ content  二维码包含的内容，文本或网址"Hello World"
         * @ path     二维码图片目录"C:/Users/Administrator/Desktop/QRcode2/b.jpg"
         * @ size     二维码图片尺寸 null or your size
         * @ logoPath 插入图片目录
         * @Date:   2018/11/26
    */
    @Test
    public void test2()  {
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        boolean mark = qrCodeUtil.zxingCodeCreate("Hello World","src/111.png",null,"./src/main/resources/1.jpg");
        System.out.println(mark);
    }


    // 解码  成功
    @Test
    public void test3()  {
        QRCodeUtil qrCodeUtil = new QRCodeUtil();
        Result mark = qrCodeUtil.zxingCodeAnalyze("src/111.png");
        System.out.println(mark);
    }


}
