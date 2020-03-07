package com.goat.chapter207.demo;

import com.goat.chapter207.base.BaseCommon;
import com.goat.chapter207.util.ImageUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.File;

/**
 * Created by Administrator on 2020/3/7.
 *
 * @ Description: 截图操作
 * Selenium中截图类 TakesScreenshot，这个类主要是获取浏览器窗体内的内容，不包括浏览器的菜单和桌面的任务栏区域，我们用百度首页来截图
 * @ author  山羊来了
 * @ date 2020/3/7---12:54
 */
public class ScreenshotsApp extends BaseCommon {

    WebDriver driver = getDriver("http://www.baidu.com");

    @Test
    public void test2() throws Exception {
        driver.manage().window().maximize();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //执行屏幕截取
        //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件;"屏幕截图"即时保存截图的文件夹
        FileUtils.copyFile(srcFile, new File("屏幕截图", System.currentTimeMillis() + ".png"));
    }

    //  通过指定元素及区域大小截图
    @Test
    public void test3() throws Exception {
        driver.manage().window().maximize();
        // 百度一下 按钮： <input type="submit" id="su" value="百度一下" class="bg s_btn">
        WebElement element = driver.findElement(By.id("su"));
        File file = ImageUtil.elementSnapshot(element);
        //System.currentTimeMillis()、Calendar.getInstance().getTimeInMillis()获取时间戳的方法
        // "屏幕截图" 存放截图文件的父目录  没有则创建
        FileUtils.copyFile(file, new File("屏幕截图", System.currentTimeMillis()+".png"));
    }

}
