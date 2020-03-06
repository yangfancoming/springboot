package com.goat.chapter207;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by Administrator on 2020/3/6.
 *
 * @ Description: selenium 打开本地html  加载本地html
 * @ author  山羊来了
 * @ date 2020/3/6---13:45
 */
public class App1 extends BaseCommon {

    String temp = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\src\\main\\java\\com\\goat\\chapter207\\html\\app1.html";

    WebDriver driver = getDriver(temp);

    @Test
    public void test(){
        // 找到链接元素
        WebElement link1 = driver.findElement(By.linkText("小坦克"));
        WebElement link11 = driver.findElement(By.partialLinkText("坦克"));
        link1.click();
    }

    @Test
    public void test2(){
        // 找到元素
        WebElement element = driver.findElement(By.id("usernameid"));
        // 在输入框中输入内容
        element.sendKeys("test111111");
        // 清空输入框
        element.clear();
        element.sendKeys("test22");
        // 模拟键盘按键
        element.sendKeys(Keys.ENTER);
        // 获取输入框的内容
        System.out.println(element.getAttribute("value"));
    }

    @Test
    public void test3(){
        //找到按钮元素
        String xpath="//input[@value='添加']";
        WebElement addButton = driver.findElement(By.xpath(xpath));
        // 点击按钮
        addButton.click();
        // 判断按钮是否enable
        System.out.println(addButton.isEnabled());
    }

    @Test
    public void test4(){
        // 找到元素
        Select select = new Select(driver.findElement(By.id("proAddItem_kind")));
        // 选择对应的选择项， index 从0开始的
        select.selectByIndex(2);
        select.selectByValue("18");
        select.selectByVisibleText("种类AA");
        // 获取所有的选项
        List<WebElement> options = select.getOptions();
        for (WebElement webElement : options) {
            System.out.println(webElement.getText());
        }
    }

    @Test
    public void test5(){
        // 找到单选框元素
        String xpath="//input[@type='radio'][@value='Banana']";
        WebElement apple = driver.findElement(By.xpath(xpath));
        //选择某个单选框
        apple.click();
        //判断某个单选框是否已经被选择
        System.out.println(apple.isSelected());
        // 获取元素属性
        System.out.println(apple.getAttribute("value"));
    }

    @Test
    public void test6(){
        // 找到单选框元素
        String xpath="//input[@type='checkbox'][@value='Banana']";
        WebElement apple = driver.findElement(By.xpath(xpath));
        //选择某个单选框
        apple.click();
        //判断某个单选框是否已经被选择
        System.out.println(apple.isSelected());
        // 获取元素属性
        System.out.println(apple.getAttribute("value"));
    }

}
