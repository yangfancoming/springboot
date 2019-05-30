package com.goat.easyexcel.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.goat.easyexcel.util.DataUtil.createTestListObject;
import static com.goat.easyexcel.util.DataUtil.createTestListStringHead;

/**
 * Created by 64274 on 2019/2/23.
 * @ Description:
 * sos 文件名 ==  @GetMapping("test2") 中的 test2
 * @ author  山羊来了
 * @ date 2019/2/23---22:42
 */
@Controller
public class DownController {

    String fileName = new String(("UserInfo" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
    Sheet sheet1 = new Sheet(1, 3);

    public DownController() throws UnsupportedEncodingException {}

    //     http://localhost:8758/test2
    @GetMapping("test2")
    public void cooperation(HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        sheet1.setSheetName("第一个1sheet");
        //设置列宽 设置每列的宽度
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        sheet1.setAutoWidth(Boolean.TRUE);
        /**  sos 下载成 zip 格式是因为 以下3行代码 注释掉后  使用 GitHub 上的 demo 代码就可以正常下载了
         response.setHeader("Content-Type","application/octet-stream");
         response.setCharacterEncoding("utf-8");
         response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName + ".xlsx","utf-8"));
        */
        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        writer.write1(createTestListObject(), sheet1);
        writer.finish();
        out.flush();
    }

    //     http://localhost:8758/a.htm
    @GetMapping("/a.htm")
    public void cooperationOk(HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        sheet1.setSheetName("第一个sheet");
        response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");

        writer.write0(createTestListStringHead(), sheet1);
        writer.finish();
        out.flush();
    }
}


