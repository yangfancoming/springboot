package com.goat.easyexcel.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.goat.easyexcel.listen.ExcelListener;
import com.goat.easyexcel.model.ReadModel;
import com.goat.easyexcel.util.FileUtil;
import org.junit.Test;
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
public class Test03Controller extends BaseController {

    /**   http://localhost:8758/test1
     * 03版本excel读数据量少于1千行数据，内部采用回调方法.
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    @GetMapping("test1")
    public void simpleReadListStringV2003() throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("2003.xls");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(1, 0));
        inputStream.close();
        print(data);
    }


    /**   http://localhost:8758/test2
     * 03版本excel读数据量少于1千行数据转成javamodel，内部采用回调方法.
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    @GetMapping("test2")
    public void simpleReadJavaModelV2003() throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("2003.xls");
        List<Object> data = EasyExcelFactory.read(inputStream, new Sheet(2, 1, ReadModel.class));
        inputStream.close();
        print(data);
    }

    /**   http://localhost:8758/test3
     * 03版本excel读数据量大于1千行数据，内部采用回调方法.
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    @GetMapping("test3")
    public void saxReadListStringV2003() throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("2003.xls");
        ExcelListener excelListener = new ExcelListener();
        EasyExcelFactory.readBySax(inputStream, new Sheet(2, 1), excelListener);
        inputStream.close();
    }

    /**  http://localhost:8758/test4
     * 03版本excel读数据量大于1千行数据转成javamodel，内部采用回调方法.
     * @throws IOException 简单抛出异常，真实环境需要catch异常,同时在finally中关闭流
     */
    @GetMapping("test4")
    public void saxReadJavaModelV2003() throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("2003.xls");
        ExcelListener excelListener = new ExcelListener();
        EasyExcelFactory.readBySax(inputStream, new Sheet(2, 1, ReadModel.class), excelListener);
        inputStream.close();
    }


}
