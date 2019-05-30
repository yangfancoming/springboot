package com.goat.easyexcel.controller;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.goat.easyexcel.listen.MyListener;
import com.goat.easyexcel.model.User;
import com.goat.easyexcel.util.FileUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
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
@RequestMapping("user")
public class UserController extends BaseController {

    /**   http://localhost:8758/user/test1 */
    @GetMapping("test1")
    public void test1()   {
        InputStream inputStream = FileUtil.getResourcesFileInputStream("user.xlsx");
        MyListener<User> listener = new MyListener();        // 解析每行结果在listener中处理
        ExcelReader excelReader = EasyExcelFactory.getReader(inputStream,listener);
        excelReader.read();
        List<User> datas = listener.getDatas(); // doit  这里断点查看后  为啥 不是 User 类型 而是 ArrayList ？？？
        System.out.println(datas);
    }


}
