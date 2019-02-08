package com.goat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by 64274 on 2019/2/8.
 *
 * @ Description: CustomerRepository 自带方法
 * @ author  山羊来了
 * @ date 2018/9/28
 */
@RestController //该 注解不能被继承
public class DeleteController extends BaseController {

    // 测试地址：    http://localhost:8453/test11
    @GetMapping("/test11")
    public void deleteAll() { // 删除全部
        repository.deleteAll();
    }

    // 测试地址：    http://localhost:8453/test22
    @GetMapping("/test22")
    public void delete() { // 按主键id 进行删除
        repository.deleteById("1");
    }


}
