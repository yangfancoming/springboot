package com.goat.chapter207.demo;

import com.goat.chapter207.base.BaseCommon;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;

import java.io.File;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: selenium 操作浏览器
 * @ author  山羊来了
 * @ date 2020/3/6---13:45
 */
public class App2 extends BaseCommon {

    String temp = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\src\\main\\java\\com\\goat\\chapter207\\html\\app1.html";

    WebDriver driver = getDriver(temp);

    @Test
    public void test(){
        WebDriver driver = getDriver("http://www.cnblogs.com/tankxiao");
        // 浏览器最大化
        driver.manage().window().maximize();
        driver.navigate().to("http://www.baidu.com");
        // 刷新浏览器
        driver.navigate().refresh();
        // 浏览器后退
        driver.navigate().back();
        // 浏览器前进
        driver.navigate().forward();
        // 浏览器退出
        driver.quit();
    }

    // 截图操作
    @Test
    public void test2(){
        driver.get("http://www.baidu.com");
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(srcFile, new File("c:\\1.png"));
    }

    // 模拟鼠标操作
    @Test
    public void test3(){
        driver.get("http://www.baidu.com");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(By.id("kw"))).perform();
    }

    // 杀掉Windows浏览器进程
    @Test
    public void test4(){
        WindowsUtils.killByName("firefox.exe");
        WindowsUtils.killByName("iexplore.exe");
        WindowsUtils.killByName("chrome.exe");
    }
}
