package com.goat.chapter207.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2020/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/6---14:20
 */
public class BaseCommon {

    protected WebDriver getDriver(String url){
        // 设置浏览器驱动
        System.setProperty("webdriver.chrome.driver", "F:\\Package\\Python_Environment\\chromedriver.exe");
        // 获取浏览器驱动实现类
        WebDriver driver  = new ChromeDriver();
        driver.get(url);
        return driver;
    }


    protected ChromeDriver getDriverForChrome(String url){
        // 设置浏览器驱动
        System.setProperty("webdriver.chrome.driver", "F:\\Package\\Python_Environment\\chromedriver.exe");
        // 获取浏览器驱动实现类
        ChromeDriver driver  = new ChromeDriver();
        driver.get(url);
        return driver;
    }
}
