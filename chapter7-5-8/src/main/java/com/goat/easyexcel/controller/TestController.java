package com.goat.easyexcel.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.goat.easyexcel.listen.ExcelListener;
import com.goat.easyexcel.model.ReadModel;
import com.goat.easyexcel.util.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 64274 on 2019/2/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/23---20:56
 */
@RestController
public class TestController {

    /**   http://localhost:8758/test1
     * 07版本excel读数据量少于1千行数据，内部采用回调方法.
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    @GetMapping("test1")
    public void simpleReadListStringV2007() throws IOException {
        InputStream in = FileUtil.getResourcesFileInputStream("2007.xlsx");// 在类路径下读取
        List<Object> data = EasyExcelFactory.read(in, new Sheet(1, 0));
        in.close();
        print(data);
    }

    /**
     * 07版本excel读数据量少于1千行数据自动转成javamodel，内部采用回调方法.
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    @GetMapping("test2")
    public void simpleReadJavaModelV2007() throws IOException {
        InputStream in = FileUtil.getResourcesFileInputStream("2007.xlsx");
        List<Object> data = EasyExcelFactory.read(in, new Sheet(2, 1, ReadModel.class));
        in.close();
        print(data);
    }

    /**
     * 07版本excel读数据量大于1千行，内部采用回调方法.
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    @GetMapping("test3")
    public void saxReadListStringV2007() throws IOException {
        InputStream in = FileUtil.getResourcesFileInputStream("2007.xlsx");
        ExcelListener excelListener = new ExcelListener();
        EasyExcelFactory.readBySax(in, new Sheet(1, 1), excelListener);
        in.close();
    }


    public void print(List<Object> datas){
        int i=0;
        for (Object ob:datas) {
            System.out.println(i++);
            System.out.println(ob);
        }
    }

}
