package com.goat.chapter207.util;

import com.goat.chapter207.model.MoveEntity;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/3/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/7---10:51
 */
public class ImageUtil {

    //文档截图后图片大小
    private static Point imageFullScreenSize = null;
    //html 大小
    private static Point htmlFullScreenSize = null;

    /**
     * 获取element的截图对应的BufferedImage对象
     * @param ele
     */
    public static BufferedImage getImageEle(ChromeDriver driver, WebElement ele) {
        try {
            // 截屏
            byte[] fullPage = driver.getScreenshotAs(OutputType.BYTES);
            BufferedImage fullImg = ImageIO.read(new ByteArrayInputStream(fullPage));
            // 获取截屏高和宽 fullImage: width:1008, height:637
            System.out.println("fullImage: width:" + fullImg.getWidth() + ", height:" + fullImg.getHeight());
            // 保存截屏
            ImageIO.write(fullImg, "png",  new File("full.png"));
            if (imageFullScreenSize == null){
                imageFullScreenSize = new Point(fullImg.getWidth(), fullImg.getHeight());
            }
            // html: width:1008, height:637  //html: width:414, height:288
            WebElement element = driver.findElement(By.cssSelector("div[class='geetest_panel geetest_wind']"));
            System.out.println("html: width:" + element.getSize().width + ", height:" + element.getSize().height);
//            if(htmlFullScreenSize == null){
//                htmlFullScreenSize = new Point(element.getSize().getWidth(), element.getSize().getHeight());
//            }
            Point point = ele.getLocation();
            // 260    616
            int eleWidth = (int)(ele.getSize().getWidth() / (float)element.getSize().width * (float)fullImg.getWidth());
            //  160   324
            int eleHeight = (int) (ele.getSize().getHeight() / (float)element.getSize().height * (float)fullImg.getHeight());
            BufferedImage eleScreenShot = fullImg.getSubimage((int)(point.getX() / (float)element.getSize().width * (float)fullImg.getWidth()), (int)(point.getY() / (float)element.getSize().height * (float)fullImg.getHeight()), eleWidth, eleHeight);
            return eleScreenShot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //开始遍历处距离左边的距离
    private static final int GEETEST_WIDTH_START_POSTION = 60;
    /**
     * 根据original.png和slider.png 的像素差异 计算需要移动的距离
     * @return
     */
    public static int calcMoveDistance() {
        //小方块距离左边界距离
        int START_DISTANCE = 6;
        int startWidth = (int)(GEETEST_WIDTH_START_POSTION * (imageFullScreenSize.x + 0.0f)/ htmlFullScreenSize.x);
        START_DISTANCE = (int)(START_DISTANCE * (imageFullScreenSize.x + 0.0f)/ htmlFullScreenSize.x);
        try {
            BufferedImage geetest1 = ImageIO.read(new File("original.png"));
            BufferedImage geetest2 = ImageIO.read(new File("slider.png"));
            for (int i = startWidth; i < geetest1.getWidth(); i++){
                for(int j = 0; j < geetest1.getHeight(); j++){
                    int[] fullRgb = test(geetest1,i,j);
                    int[] bgRgb = test(geetest2,i,j);
                    if(difference(fullRgb, bgRgb) > 255){
                        int moveDistance = (int)((i - START_DISTANCE) / ((imageFullScreenSize.x + 0.0f)/ htmlFullScreenSize.x));
                        System.out.println("需要移动的距离:" + moveDistance);
                        return moveDistance;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("计算移动距离失败");
    }

    private static int[] test(BufferedImage image,int i,int j){
        int[] test = new int[3];
        test[0] = (image.getRGB(i, j)  & 0xff0000) >> 16;
        test[1] = (image.getRGB(i, j)  & 0xff00) >> 8;
        test[2] = (image.getRGB(i, j)  & 0xff);
        return test;
    }

    private static int difference(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]) + Math.abs(a[2] - b[2]);
    }

    public static List<MoveEntity> getMoveEntity(int distance){
        List<MoveEntity> list = new ArrayList<>();
        int i = 0;
        do {
            MoveEntity moveEntity = new MoveEntity();
            int r = RandomUtils.nextInt(5, 8);
            moveEntity.setX(r);
            moveEntity.setY(RandomUtils.nextInt(0, 1)==1?RandomUtils.nextInt(0, 2):0-RandomUtils.nextInt(0, 2));
            int s;
            if(i/Double.valueOf(distance)>0.05){
                if(i/Double.valueOf(distance)<0.85){
                    s = RandomUtils.nextInt(2, 5);
                }else {
                    s = RandomUtils.nextInt(10, 15);
                }
            }else{
                s = RandomUtils.nextInt(20, 30);
            }
            moveEntity.setSleepTime(s);
            list.add(moveEntity);
            i = i + r;
        } while (i <= distance+5);
        boolean cc= i>distance;
        for (int j = 0; j < Math.abs(distance-i); ) {
            int r = RandomUtils.nextInt(1, 3);
            MoveEntity moveEntity = new MoveEntity();
            moveEntity.setX(cc?-r:r);
            moveEntity.setY(0);
            moveEntity.setSleepTime(RandomUtils.nextInt(100, 200));
            list.add(moveEntity);
            j = j+r;
        }
        return list;
    }

}
