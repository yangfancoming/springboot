package com.goat;

import com.goat.service.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private ApplicationContext ac;

    @Autowired private IEmpService iEmpService;

    @Test
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    // 这里可以正常返回查询结果
    @Test
    public void findById() {
        List<Map> maps = iEmpService.findById("7369");
        System.out.println(maps);
    }
    //   报错除零异常仍然将数据插入到数据库了 java.lang.ArithmeticException: / by zero
    @Test
    public void saveEmp() {
        Integer temp  = iEmpService.saveEmp(11,"haha");
        System.out.println(temp);
    }

    //   报错除零异常 并没将数据插入到数据库 表明 事务回滚了 这就是@Transactional 注解的作用  java.lang.ArithmeticException: / by zero
    @Test
    public void saveEmp2() {
        Integer temp  = iEmpService.saveEmp2(22,"haha");
        System.out.println(temp);
    }

    // @Transactional(rollbackFor = Exception.class)  抛出自定义异常 也会回滚！
    @Test
    public void saveEmp3() {
        Integer temp  = iEmpService.saveEmp3(33,"aaaaa");
        System.out.println(temp);
    }

}
