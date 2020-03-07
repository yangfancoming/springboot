package com.goat.chapter207.slider;

import com.goat.chapter207.base.BaseCommon;
import com.goat.chapter207.util.ImageUtil;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/6---17:27
 */
public class BiliApp extends BaseCommon {

    ChromeDriver driver = getDriverForChrome("https://passport.bilibili.com/login");

    private static String prefix = "bibi";
    @Test
    public void test() throws Exception {
        driver.manage().window().setSize(new Dimension(1024, 768));
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2 * 1000);
        // 账号输入框： <input type="text" value="" placeholder="你的手机号/邮箱" id="login-username" maxlength="50" autocomplete="off" class="">
        driver.findElement(By.id("login-username")).sendKeys("123");
        // 密码输入框： <input type="password" placeholder="密码" id="login-passwd" class="">
        driver.findElement(By.id("login-passwd")).sendKeys("123");
        // 登录按钮： <a class="btn btn-login">登录</a>
        driver.findElement(By.xpath("//*[@id=\"geetest-wrap\"]/div/div[5]/a[1]")).click();
        Thread.sleep(3 * 1000);

        //图一  滑块图  带有水印   doit 报错   由于getImageEle内部geetest_panel geetest_wind问题
        BufferedImage image = ImageUtil.getImageEle(driver,driver.findElement(By.cssSelector("canvas[class='geetest_canvas_bg geetest_absolute']")));
        ImageIO.write(image, "png",  new File( prefix + "slider.png"));

    }
}

