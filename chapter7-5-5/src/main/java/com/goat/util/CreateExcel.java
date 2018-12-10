package com.goat.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * Created by 64274 on 2018/12/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/10---21:54
 */
public class CreateExcel {

    public static void createExcel(String excelName) throws Exception {

        XSSFWorkbook wb = new XSSFWorkbook(); //创建工作簿
        XSSFSheet sheet = wb.createSheet();  //创建一个sheet

        // 创建单元格样式
        XSSFCellStyle style =  wb.createCellStyle();
        style.setFillForegroundColor((short)4); //设置要添加表格北京颜色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); //solid 填充
        style.setAlignment(HorizontalAlignment.CENTER); //文字水平居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//文字垂直居中
        style.setBorderBottom(BorderStyle.THIN); //底边框加黑
        style.setBorderLeft(BorderStyle.THIN);  //左边框加黑
        style.setBorderRight(BorderStyle.THIN); // 有边框加黑
        style.setBorderTop(BorderStyle.THIN); //上边框加黑
        //为单元格添加背景样式
        for (int i = 0; i < 6; i++) { //需要6行表格
            Row row =	sheet.createRow(i); //创建行
            for (int j = 0; j < 6; j++) {//需要6列
                row.createCell(j).setCellStyle(style);
            }
        }

        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));//合并单元格，cellRangAddress四个参数，第一个起始行，第二终止行，第三个起始列，第四个终止列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 5));

        //tian入数据
        XSSFRow row = sheet.getRow(0); //获取第一行
        row.getCell(1).setCellValue("2018期末考试"); //在第一行中创建一个单元格并赋值
        XSSFRow row1 = sheet.getRow(1); //获取第二行，为每一列添加字段
        row1.getCell(1).setCellValue("语文");
        row1.getCell(2).setCellValue("数学");
        row1.getCell(3).setCellValue("英语");
        row1.getCell(4).setCellValue("物理");
        row1.getCell(5).setCellValue("化学");
        XSSFRow row2 = sheet.getRow(2); //获取第三行
        row2.getCell(0).setCellValue("张三");
        XSSFRow row3 = sheet.getRow(3); //获取第四行
        row3.getCell(0).setCellValue("张三");
        XSSFRow row4 = sheet.getRow(4); //获取第五行
        row4.getCell(0).setCellValue("张三");
        XSSFRow row5 = sheet.getRow(5); //获取第五行
        row5.getCell(0).setCellValue("张三");
        //将数据写入文件
        FileOutputStream out = new FileOutputStream(excelName);
        wb.write(out);

    }

}
