package com.goat.chapter207.slider;

import com.goat.chapter207.base.BaseCommon;
import com.goat.chapter207.model.MoveEntity;
import com.goat.chapter207.util.ImageUtil;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/6---17:27
 */
public class App extends BaseCommon {

    ChromeDriver driver = getDriverForChrome("https://www.geetest.com/demo/slide-bind.html");

    private static String BASE_PATH = "";

    @Test
    public void test() throws Exception {
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        Thread.sleep(2 * 1000);
        // 登录按钮触发滑块： <div id="btn" class="btn">提交</div>
        driver.findElement(By.className("btn")).click();
        Thread.sleep(3 * 1000);

        //图一  滑块图  带有水印
        BufferedImage image = ImageUtil.getImageEle(driver,driver.findElement(By.cssSelector("canvas[class='geetest_canvas_bg geetest_absolute']")));
        ImageIO.write(image, "png",  new File( "slider.png"));
        //设置原图可见   滑块图 没有水印
        driver.executeScript("document.getElementsByClassName(\"geetest_canvas_fullbg geetest_fade geetest_absolute\")[0].setAttribute('style', 'display: block')\n");
        //图二  滑块图 没有水印
        image = ImageUtil.getImageEle(driver,driver.findElement(By.cssSelector("canvas[class='geetest_canvas_fullbg geetest_fade geetest_absolute']")));
        ImageIO.write(image, "png",  new File(BASE_PATH + "original.png"));
        // 获取后再隐藏原图
        driver.executeScript("document.getElementsByClassName(\"geetest_canvas_fullbg\")[0].setAttribute('style', 'display: none')\n");

        // 滑块按钮： <div class="geetest_slider_button" style="opacity: 1; transform: translate(0px, 0px);"></div>
        WebElement element = driver.findElement(By.className("geetest_slider_button"));
        // 定义鼠标模拟动作
        Actions actions = new Actions(driver);
        // 鼠标左击滑块按钮 并按住
        actions.clickAndHold(element).perform();
        // 计算滑块按钮 移动距离
        int moveDistance = ImageUtil.calcMoveDistance();
        int d = 0;

        List<MoveEntity> list = ImageUtil.getMoveEntity(moveDistance);
        // 开始循环移动校准
        for(MoveEntity moveEntity : list){
            // 鼠标移动
            actions.moveByOffset(moveEntity.getX(), moveEntity.getY()).perform();
            System.out.println("向右总共移动了:" + (d = d + moveEntity.getX()));
            Thread.sleep(moveEntity.getSleepTime());
        }
        // 抬起鼠标左键
        actions.release(element).perform();
        Thread.sleep(1 * 1000);
    }
}

/**
 *         String original = "geetest_canvas_fullbg geetest_fade geetest_absolute";
 //设置原图可见   滑块图 没有水印
 driver.executeScript("document.getElementsByClassName("+original+")[0].setAttribute('style', 'display: block')\n");

 //图二
 image = ImageUtil.getImageEle(driver,driver.findElement(By.cssSelector("canvas[class="+original+"]")));
 ImageIO.write(image, "png",  new File(BASE_PATH + "original.png"));
*/