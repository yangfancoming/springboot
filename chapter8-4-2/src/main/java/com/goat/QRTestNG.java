package com.goat;

import com.goat.utils.QRCodeUtil;
import com.google.zxing.Result;
import org.testng.annotations.Test;


public class QRTestNG {

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
