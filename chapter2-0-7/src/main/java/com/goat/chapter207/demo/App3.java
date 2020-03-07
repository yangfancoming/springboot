package com.goat.chapter207.demo;

import com.goat.chapter207.base.BaseCommon;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: selenium 操作弹出对话框
 * @ author  山羊来了
 * @ date 2020/3/6---13:45
 */
public class App3 extends BaseCommon {

    String temp = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\src\\main\\java\\com\\goat\\chapter207\\html\\app3.html";

    WebDriver driver = getDriver(temp);

    // alert 提示框
    @Test
    public void test(){
        // 定位弹出按钮
        WebElement alertButton = driver.findElement(By.xpath("/html/body/button[3]"));
        // 点击弹出 alert 按钮
        alertButton.click();
        // 将焦点移至 alert 控件上
        Alert javascriptAlert = driver.switchTo().alert();
        // 获取 提示框的提示内容
        System.out.println(javascriptAlert.getText());
        // 关掉提示框
        javascriptAlert.accept();
    }

    // confirm 确认框
    @Test
    public void test1(){
        WebElement confirmButton = driver.findElement(By.xpath("/html/body/button[1]"));
        confirmButton.click();
        Alert javascriptConfirm = driver.switchTo().alert();
        // 点击确定按钮
        javascriptConfirm.accept();

        confirmButton.click();
        javascriptConfirm = driver.switchTo().alert();
        // 点击取消按钮
        javascriptConfirm.dismiss();
    }


    //  输入框
    @Test
    public void test3(){
        WebElement promptButton = driver.findElement(By.xpath("/html/body/button[2]"));
        promptButton.click();
        Alert javascriptPrompt = driver.switchTo().alert();
        javascriptPrompt.sendKeys("This is learning Selenium");
        // 获取输入框的提示信息
        System.out.println(javascriptPrompt.getText());
        javascriptPrompt.accept();

        promptButton.click();
        javascriptPrompt=driver.switchTo().alert();
        javascriptPrompt.dismiss();

        promptButton.click();
        javascriptPrompt=driver.switchTo().alert();
        javascriptPrompt.accept();
    }

}
