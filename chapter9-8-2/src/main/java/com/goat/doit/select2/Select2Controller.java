package com.goat.doit.select2;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.system.model.Role;
import com.goat.doit.system.service.RoleService;
import com.goat.doit.system.vo.base.PageResultVo;
import com.goat.doit.system.vo.base.ResponseVo;
import com.goat.doit.util.PageUtil;
import com.goat.doit.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/select2")
public class Select2Controller {

    private static final Logger logger = LoggerFactory.getLogger(Select2Controller.class);

    @Autowired
    private RoleService roleService;


    // 测试地址：    http://localhost:8263/select2/test1
    @GetMapping("/test1")
    public String success(Map<String,String> map){ // 这里的 map 一定要作为参数  不能 在函数内 new出来 否则 前端无法渲染
        map.put("hello","123123");
        return "select2/demo01";
    }

    /*
        测试地址：    http://localhost:8982/select2/list
        现象：User 对象中出现的 userId 属性 与 chapter0-0-1 中的 User 属性id 不一致！
        报错：Caused by: org.springframework.expression.spel.SpelEvaluationException: EL1008E: Property or field 'id' cannot be found on object of type 'com.goat.bean.User' - maybe not public or not valid?
        原因：pom.xml 文件中 没有加入  sos <packaging>war</packaging>
    */
//    @GetMapping("/list")
//    public String userlist(Model model) {
//        List<Account> list = new ArrayList<>();
//        list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
//        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
//        list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
//        list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
//        model.addAttribute("accountList",list);
//        return "select2/demo01";
//    }


    /*角色列表数据*/
    @GetMapping("/list")
    @ResponseBody
    public PageResultVo pageRoles(Model model,Account role, Integer limit, Integer offset) {
        try {
            PageHelper.startPage(PageUtil.getPageNo(10, 0),10);
            List<Account> list = new ArrayList<>();
            list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
            list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
            list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
            list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
            model.addAttribute("accountList",list);
            PageInfo<Account> pages = new PageInfo<>(list);
            return ResultUtil.table(list,pages.getTotal());
        } catch (Exception e) {
            logger.error(String.format("RoleController.loadRoles%s", e));
            throw e;
        }
    }

}
