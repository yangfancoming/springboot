package com.goat.easyexcel.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.goat.easyexcel.util.DataUtil.createTestListObject;
import static com.goat.easyexcel.util.DataUtil.createTestListStringHead;

/**
 * Created by 64274 on 2019/2/23.
 *
 * @ Description: doit  这里的下载 为什么 一直是被自动转成了 zip格式  而且 文件名 总是test1.zip ？？？？
 * @ author  山羊来了
 * @ date 2019/2/23---22:42
 */
@Controller
public class DownController {
    //     http://localhost:8758/test1
    @GetMapping("test1")
    public void cooperation(HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = new String(("UserInfo" + new SimpleDateFormat("yyyy-MM-dd").format(new Date())).getBytes(), "UTF-8");
        //写第一个sheet, sheet1  数据全是List<String> 无模型映射关系
        Sheet sheet1 = new Sheet(1, 3);
        sheet1.setSheetName("第一个1sheet");
        //设置列宽 设置每列的宽度
        sheet1.setHead(createTestListStringHead());
        //or 设置自适应宽度
        //sheet1.setAutoWidth(Boolean.TRUE);
        writer.write1(createTestListObject(), sheet1);
        writer.finish();
        response.setHeader("Content-Type","application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(fileName + ".xlsx","utf-8"));
        out.flush();
    }


}
