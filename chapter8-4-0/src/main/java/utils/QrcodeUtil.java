package utils;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by 64274 on 2018/11/26.
 *
 * @author 山羊来了
 * @Description: doit  有时间调试下 为什么自己照着视频敲的代码  生成出来的 二维码 是黑屏的？ 而 网copy的代码 CreateQRCode 类  一跑就是OK 的。。。
 * @date 2018/11/26---19:12
 */
public class QrcodeUtil {

    /**
     * @Description: 加密： 文字---> 二维码
     * @author Goat
     * @date 2018年11月26日20:01:36
     * @param content  要加密的文字信息
     * @param imgPath  生成二维码图片 路径
     * @param imgType  生成二维码图片 类型
     * @param size     生成二维码图片 大小
     * @return
     */
    public void encodeQRcode(String content,String imgPath,String imgType,int size) throws IOException {

        // 将字符串(待加密的文字信息) 转成 二位数组
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');// 设置二维码的 排错率 7% < L M  Q  H  <30%  值越高 可存储信息越少 对二维码清晰度要求越小
        qrcode.setQrcodeEncodeMode('B');// 二维码中 可存放的信息类型  N 数字   A 数字+ A-Z   B 所有
        qrcode.setQrcodeVersion(size);// 二维码的尺寸  数值越大  二维码越大  1 - 40

        int imgSize = 64 + 12*(size - 1);// 将图片在内存中 放大

        File file = new File(imgPath);
        BufferedImage bufferedImage = new BufferedImage(imgSize,imgSize,BufferedImage.TYPE_INT_RGB); // 内存中一张图片
        ImageIO.write(bufferedImage,imgType,file);
        Graphics2D gs =bufferedImage.createGraphics(); // 创建画板
        gs.setBackground(Color.WHITE);// 设置画板 背景色
        gs.clearRect(0,0,imgSize,imgSize);//  设置 指定区域颜色
        gs.setColor(Color.BLACK);// 设置二维码颜色
        byte[] bs = content.getBytes("utf-8");
        boolean[][] codeOut = qrcode.calQrcode(bs);
        int pixOff = 2;
        qrFillRect(gs, codeOut, pixOff);
        gs.dispose();
        bufferedImage.flush();

    }

    public static void qrFillRect(Graphics2D gs, boolean[][] codeOut, int pixOff) {
        for (int i = 0; i < codeOut.length ; i++) {
            for (int j = 0; j < codeOut.length; j++) {
                if(codeOut[i][j]){
                    gs.fillRect(j*3+pixOff,i*3+pixOff,3,3);
                }
            }
        }
    }

}
