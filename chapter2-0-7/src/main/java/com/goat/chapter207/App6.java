package com.goat.chapter207;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: selenium  处理Iframe 中的元素
 * @ author  山羊来了
 * @ date 2020/3/6---13:45
 */
public class App6 extends BaseCommon {

    String temp = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\src\\main\\java\\com\\goat\\chapter207\\html\\app6.html";

    WebDriver driver = getDriver(temp);

    // 隐式等待
    @Test
    public void test() {
        // 在 主窗口的时候
        driver.findElement(By.id("maininput")).sendKeys("main input");
        // 此时 没有进入到iframe, 以下语句会报错
        //driver.findElement(By.id("iframeinput")).sendKeys("iframe input");

        driver.switchTo().frame("frameA");
        driver.findElement(By.id("iframeinput")).sendKeys("iframe input");

        // 此时没有在主窗口，下面语句会报错
        //driver.findElement(By.id("maininput")).sendKeys("main input");

        // 回到主窗口
        driver.switchTo().defaultContent();
        driver.findElement(By.id("maininput")).sendKeys("main input");
    }



}
