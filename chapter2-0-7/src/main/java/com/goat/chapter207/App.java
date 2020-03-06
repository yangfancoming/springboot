package com.goat.chapter207;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2020/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/6---11:19
 */
public class App {

    @Test
    public void test1(){
        // 设置浏览器驱动
        System.setProperty("webdriver.chrome.driver", "F:\\Package\\Python_Environment\\chromedriver.exe");
        // 获取浏览器驱动实现类
        WebDriver driver  = new ChromeDriver();
        // 打开百度网页
        driver.get("http://www.baidu.com");
        // 百度搜索框：   <input id="kw" name="wd" class="s_ipt" value="" maxlength="255" autocomplete="off">
        WebElement searchBox = driver.findElement(By.id("kw"));
        // 模拟控件输入
        searchBox.sendKeys("山羊来了");
        // 百度一下 搜索按钮： <input type="submit" id="su" value="百度一下" class="bg s_btn">
        WebElement searchButton = driver.findElement(By.id("su"));
        // 模拟按钮点击
        searchButton.submit();
        // 关闭驱动
        driver.close();
    }
}
