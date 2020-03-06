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
 * @ date 2020/3/6---13:13
 */
public class SkyEye {

    // 打开天眼查首页  并在搜索框输入内容
    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "F:\\Package\\Python_Environment\\chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        // 打开天眼查首页
        driver.get("https://www.tianyancha.com/");
        // <input type="search" id="home-main-search" class="input -xl js-live-search-auto" wrap-class="-index" maxlength="50" click-selected="header.suggestToCompany" placeholder="请输入公司名称、老板姓名、品牌名称等" autocomplete="off">
        WebElement searchBox = driver.findElement(By.id("home-main-search"));
        searchBox.sendKeys("山羊公司");
    }

}
