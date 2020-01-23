package com.goat.util;

import org.apache.poi.hssf.usermodel.HSSFObjectData;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by 64274 on 2018/12/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/10---22:00
 */
public class ReadExcel {

    public static void readExcel(String excelName) throws IOException {
        InputStream in  = new FileInputStream(new File(excelName));  //将文件读入
        XSSFWorkbook wb = new XSSFWorkbook(in); //创建工作簿
        Sheet sheet = wb.getSheetAt(0);  //读取第一个sheet
        Row row = sheet.getRow(1);  //获取第二行
        for (int i = 1; i < 6; i++) {  //循环读取科目
            System.out.println(row.getCell(i));
        }
    }

    public static void readExcel2(String excelName) throws IOException {
        InputStream in  = new FileInputStream(new File(excelName));  //将文件读入
        HSSFWorkbook wb = new HSSFWorkbook(in); //创建工作簿
//        Sheet sheet = wb.getSheetAt(0);  //读取第一个sheet
        List<HSSFObjectData> list = wb.getAllEmbeddedObjects();
        assertEquals(list.size(), 1);
        HSSFObjectData obj = list.get(0);
        assertNotNull(obj.getObjectData());
        assertNotNull(obj.getOLE2ClassName());
        System.out.println(111);
    }
}
