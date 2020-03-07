package com.goat.chapter207.demo;

import com.goat.chapter207.base.BaseCommon;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: selenium 智能等待页面加载完成
 * @ author  山羊来了
 * @ date 2020/3/6---13:45
 *
 * 在代码里， 通过         Set<String> allWindowsId = driver.getWindowHandles();
 * 来获取到所有弹出浏览器的句柄，   然后遍历，  使用swithcto.window(newwindow_handle)方法。 就可以定位到新的窗口
 */
public class App5 extends BaseCommon {

    String temp = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\src\\main\\java\\com\\goat\\chapter207\\html\\app5.html";

    WebDriver driver = getDriver(temp);

    // 隐式等待
    @Test
    public void test() throws InterruptedException {
        WebElement b = driver.findElement(By.id("b"));
        b.click();
        Thread.sleep(6000);
        // 总共等待10秒， 如果10秒后，元素还不存在，就会抛出异常  org.openqa.selenium.NoSuchElementException
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.cssSelector(".red_box"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border = \"5px solid yellow\"",element);
    }

    /**
     *  显式等待
     *  只有满足显式等待的条件满足，测试代码才会继续向后执行后续的测试逻辑
     *  如果超过设定的最大显式等待时间阈值， 这测试程序会抛出异常。
    */
    @Test
    public void test2() {
        WebElement b = driver.findElement(By.id("b"));
        b.click();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".red_box")));
        WebElement element = driver.findElement(By.cssSelector(".red_box"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border = \"5px solid yellow\"",element);

    }

    /**
     * 等待的条件 WebDriver方法
     * 页面元素是否在页面上可用和可被单击 elementToBeClickable(By locator)
     * 页面元素处于被选中状态 elementToBeSelected(WebElement element)
     * 页面元素在页面中存在 presenceOfElementLocated(By locator)
     * 在页面元素中是否包含特定的文本  textToBePresentInElement(By locator)
     * 页面元素值    textToBePresentInElementValue(By locator, java.lang.String text)
     * 标题 (title)   titleContains(java.lang.String title)
    */


}
