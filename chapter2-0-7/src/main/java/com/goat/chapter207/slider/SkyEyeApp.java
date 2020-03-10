package com.goat.chapter207.slider;

import com.goat.chapter207.base.BaseCommon;
import com.goat.chapter207.model.MoveEntity;
import com.goat.chapter207.util.ImageUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/6---17:27
 */
public class SkyEyeApp extends BaseCommon {

    WebDriver driver = getDriverForChrome("https://www.tianyancha.com/login");

    @Test
    public void test() throws Exception {
//        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Thread.sleep(2 * 1000);
        /**
         * div[active-tab='1']  密码登录
         * div[active-tab='2']  短信登录/注册
        */
        WebElement element = driver.findElement(By.cssSelector("div[active-tab='1']"));
        System.out.println(element.getAttribute("onclick"));// loginObj.changeCurrent(2);
        // 点击 密码登录  tab页
        element.click();
//        Thread.sleep(15 * 1000);
        driver.findElement(By.id("mobile")).sendKeys("151 0413 2033");
        driver.findElement(By.id("password")).sendKeys("8965236978");
        // 点击登录按钮 弹出滑块验证框
        driver.findElement(By.xpath("//*[@id=\"web-content\"]/div/div[2]/div/div/div[3]/div[3]/div[2]/div[4]")).click();
        move();
    }

    // 开始循环移动校准
    public void move() throws Exception {
        Thread.sleep(2 * 1000);
        // 定位 图片框 区域
        WebElement origin = driver.findElement(By.cssSelector("div[class='gt_box']"));
        File file = ImageUtil.elementSnapshot(origin);
        FileUtils.copyFile(file, new File("屏幕截图", "origin.png"));

        // 定位滑块按钮
        WebElement slider = driver.findElement(By.cssSelector("div[class='gt_slider_knob gt_show']"));
        // 定义鼠标模拟动作
        Actions actions = new Actions(driver);
        // 鼠标左击滑块按钮 并按住
        actions.clickAndHold(slider).perform();
        Thread.sleep(1 * 1000);
        // 按下后 出现水印
        WebElement watermark = driver.findElement(By.cssSelector("div[class='gt_box']"));
        File temp = ImageUtil.elementSnapshot(watermark);
        FileUtils.copyFile(temp, new File("屏幕截图", "watermark.png"));

        // 抬起滑块
        actions.release(slider).perform();
        Thread.sleep(2 * 1000);

        // 计算滑块按钮 移动距离
        BufferedImage originTemp = ImageIO.read(new File("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\屏幕截图\\origin.png"));
        BufferedImage watermarkTemp = ImageIO.read(new File("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\屏幕截图\\watermark.png"));
        int moveDistance = ImageUtil.calcMoveDistance(originTemp,watermarkTemp);
        List<MoveEntity> list = ImageUtil.getMoveEntity(moveDistance);

        // 鼠标左击滑块按钮 并按住
        actions.clickAndHold(slider).perform();
        for(MoveEntity moveEntity : list){
            // 鼠标移动
            actions.moveByOffset(moveEntity.getX(), moveEntity.getY()).perform();
            Thread.sleep(20);
        }
        // 抬起鼠标左键
        actions.release(slider).perform();

        // <span class="gt_info_type">验证失败:</span>
        WebElement result2 = driver.findElement(By.cssSelector("span[class='gt_info_type']"));
        System.out.println("操作后结果 isDisplayed：" + result2.isDisplayed());
        System.out.println("操作后结果 isEnabled：" + result2.isEnabled());
        System.out.println("操作后结果 innerText：" + result2.getAttribute("innerText"));

        String innerText = result2.getAttribute("innerText");
        System.out.println("操作后结果：" + innerText);
        if (innerText.equals("再来一次:") || innerText.equals("验证失败:")){
            System.out.println("再来一次");
            Thread.sleep(5 * 1000);
            move();
        }
    }
}



