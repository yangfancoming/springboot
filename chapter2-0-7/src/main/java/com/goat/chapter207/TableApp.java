package com.goat.chapter207;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2020/3/6.
 * @ Description: selenium  操作table元素
 * @ author  山羊来了
 * @ date 2020/3/6---13:45
 */
public class TableApp extends BaseCommon {

    String temp = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter2-0-7\\src\\main\\java\\com\\goat\\chapter207\\html\\table.html";

    WebDriver driver = getDriver(temp);

    public static String tableCell(WebDriver driver,int row, int column){
        row = row + 1; //avoid get the head line of the table
        String xpath="//*[@id='table138']/tbody/tr["+row+"]/td["+column+"]";
        WebElement table = driver.findElement(By.xpath(xpath)); //*[@id="table138"]/tbody/tr[1]/td[1]/strong
        String text = table.getText();
        return text;
    }

    @Test
    public void test() {
        String s = tableCell(driver,1,1);
        System.out.println(s);
    }

}
