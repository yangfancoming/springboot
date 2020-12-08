package com.goat.chapter207.slider;

import com.goat.chapter207.base.BaseCommon;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: 药智网 爬虫
 * @ author  山羊来了
 * @ date 2020/3/6---17:27
 */
public class MedicineApp extends BaseCommon {

    ChromeDriver driver = getDriverForChrome("https://www.yaozh.com/login/");

    @Test
    public void test() throws Exception {
        // 重置浏览器窗口大小
        driver.manage().window().setSize(new Dimension(1024, 768));
//        driver.manage().window().maximize(); // 浏览器窗口最大化
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2 * 1000);
        // 账号输入框：  <input type="text" name="username" id="username" class="checkitem" placeholder="手机号/用户名/邮箱">
        driver.findElement(By.id("username")).sendKeys("mybatis");
        // 密码输入框： <input type="password" name="pwd" id="pwd" class="checkitem" placeholder="密码">
        driver.findElement(By.id("pwd")).sendKeys("jwfl724168");
        // 登录按钮：  <button id="button" class="in" type="submit" value="登录" style="cursor: pointer">登 录</button>
        driver.findElement(By.id("button")).click();
        Thread.sleep(3* 1000);

        // 点击数据库 tab 标签
        driver.findElement(By.xpath("/html/body/div[3]/div/a[3]")).click();
        Thread.sleep(2* 1000);

        // 内容是嵌套的弹窗，需要切换到新的handle上
//        0 = "CDwindow-D59595FD301E6074D23B57D521314325"
//        1 = "CDwindow-3E069782FD77769EA7B6028315D92EA7"
        List<String> result = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(result.get(1));
        // 点击 关闭广告图片 //*[@id="ad-dialog"]/div/img  <img src="/Public/images/icon_close.png">
        driver.findElement(By.xpath("//*[@id=\"ad-dialog\"]/div/img")).click();

        // 模拟鼠标悬停 合理用药 tab 标签 <a class="name arrow" href="javascript:;" title="">合理用药</a>
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).clickAndHold().perform();

        // 点击  <a class="vm" href="/instruct" title=""> 药品说明书 </a>
        driver.findElement(By.xpath("/html/body/div[3]/ul/li[3]/ul/li[1]/a")).click();


    }
}

