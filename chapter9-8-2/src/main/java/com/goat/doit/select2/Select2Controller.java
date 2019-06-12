package com.goat.doit.select2;


import com.goat.doit.system.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/select2")
public class Select2Controller {

    // 测试地址：    http://localhost:8263/select2/test1
    @GetMapping("/test1")
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","123123");
        return "select2/demo01";
    }


    List<Select2> select2List = new ArrayList<>();

    public List<Select2> init(){
        select2List.clear();
        select2List.add(new Select2(1,"1"));
        select2List.add(new Select2(2,"2"));
        select2List.add(new Select2(3,"3"));
        return select2List;
    }


    @GetMapping("/list")
    public String pageRoles(Model model) {
        List<Account> list = new ArrayList<>();
        list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
        list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
        list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
        model.addAttribute("accountList",list);
        List<Select2> select2List = init();
        model.addAttribute("provList",select2List);
        return "/select2/demo01";
    }

}
