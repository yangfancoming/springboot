package com.goat.chapter207.demo;

import com.goat.chapter207.base.BaseCommon;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by Administrator on 2020/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/6---11:19
 */
public class DemoApp extends BaseCommon {


    // 通过ID查找元素: By.id()
    @Test
    public void test1(){
        // 打开百度网页
        WebDriver driver = getDriver("http://www.baidu.com");
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

    // 通过Name查找元素: By.name()
    @Test
    public void test2(){
        WebDriver driver = getDriver("http://www.douban.com");
        // 首页搜索框：   <input type="text" maxlength="60" size="12" placeholder="书籍、电影、音乐、小组、小站、成员" name="q" autocomplete="off">
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("山羊来了");
        searchBox.submit();
        driver.close();
    }

    // 通过TagName查找元素: By.tagName() 并结合 type属性进行过滤
    @Test
    public void test3(){
        WebDriver driver = getDriver("http://www.cnblogs.com");
        List<WebElement> buttons = driver.findElements(By.tagName("input"));
        for (WebElement webElement : buttons) {
            if (webElement.getAttribute("type").equals("text")) {
                System.out.println("input text is :" + webElement.getAttribute("value"));
            }
        }
        driver.close();
    }

    /**
     * 通过ClassName 查找元素 By.className
     * 复合型className，完整的定位不到，需要用部分的名称才可以定位到，比如：ipt ipt-pwd js-pass-word
     * 需要分串才可以定位到  .ipt .ipt-pwd .js-pass-word
    */
    @Test
    public void test4() {
        WebDriver driver = getDriver("http://www.taobao.com");
        WebElement vip = driver.findElement(By.className("search-combobox-input"));
        vip.sendKeys("羽绒服");
    }

    // 鼠标悬停操作
    @Test
    public void test5() {
        WebDriver driver = getDriver("http://www.taobao.com");
        // 页面最大化
        driver.manage().window().maximize();
        WebElement temp = driver.findElement(By.id("J_SiteNavMytaobao"));
        //创建鼠标属性方法
        Actions action = new Actions(driver);
        action.moveToElement(temp).perform(); // 鼠标悬停
//        action.click();// 鼠标左击
//        action.contextClick();// 鼠标右击
//        action.doubleClick();// 鼠标双击
//        action.clickAndHold();// 鼠标左击并按住
    }

    // 通过 xpath 查找元素  By.xpath("//*[@id=\"home-main-search\"]")
    @Test
    public void test6() {
        WebDriver driver = getDriver("http://www.tianyancha.com");
        WebElement temp = driver.findElement(By.xpath("//*[@id=\"home-main-search\"]"));
        temp.sendKeys("山羊公司");
    }
}
