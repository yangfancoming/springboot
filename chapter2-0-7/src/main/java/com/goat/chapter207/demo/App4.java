package com.goat.chapter207.demo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: selenium 操作新打开页面
 * @ author  山羊来了
 * @ date 2020/3/6---13:45
 *
 * 在代码里， 通过         Set<String> allWindowsId = driver.getWindowHandles();
 * 来获取到所有弹出浏览器的句柄，   然后遍历，  使用swithcto.window(newwindow_handle)方法。 就可以定位到新的窗口
 */
public class App4 extends BaseCommon {

    String temp = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\src\\main\\java\\com\\goat\\chapter207\\html\\app4.html";

    WebDriver driver = getDriver(temp);

    // alert 提示框
    @Test
    public void test(){
        // 获取当前窗口的句柄
        String parentWindowId = driver.getWindowHandle();
        System.out.println("driver.getTitle(): " + driver.getTitle());
        // 定位打开窗口按钮
        WebElement button = driver.findElement(By.xpath("//input[@value='打开窗口']"));
        button.click();

        // 来获取到所有弹出浏览器的句柄
        Set<String> allWindowsId = driver.getWindowHandles();

        // 获取所有的打开窗口的句柄
        for (String windowId : allWindowsId) {
            if (driver.switchTo().window(windowId).getTitle().contains("博客园")) {
                driver.switchTo().window(windowId);
                break;
            }
        }
        System.out.println("driver.getTitle(): " + driver.getTitle());
        // 再次切换回原来的父窗口
        driver.switchTo().window(parentWindowId);
        System.out.println("parentWindowId: " + driver.getTitle());
    }



}
