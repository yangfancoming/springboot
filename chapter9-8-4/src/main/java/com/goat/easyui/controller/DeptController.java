package com.goat.easyui.controller;


import com.github.pagehelper.PageInfo;
import com.goat.easyui.domain.Dept;
import com.goat.easyui.domain.QueryRequest;
import com.goat.easyui.resultmodel.RestResult;
import com.goat.easyui.resultmodel.ResultGenerator;
import com.goat.easyui.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {

    private final ResultGenerator generator = new ResultGenerator();
	@Autowired
	private IDeptService deptService;

    @RequestMapping("/list")
    @ResponseBody
    public RestResult roleList(QueryRequest request, Dept dept) {
        List<Dept> list = deptService.findByPage(request.getPage(), request.getRows());
        PageInfo<Dept> pageInfo = new PageInfo<>(list);
        return generator.getSuccessUiResult("datang", pageInfo.getList(), pageInfo.getTotal());
    }

    // http://localhost:8984/role/save
    @PostMapping("/save")
    public RestResult saveUser(Dept role) {
        boolean save = deptService.save(role);
        System.out.println(save);
        return generator.getSuccessResult();
    }


    // http://localhost:8984/role/delete/66
    @DeleteMapping("/deleteId/{id}")
    public RestResult deleteById(@PathVariable Long id) {
        deptService.removeById(id);
        return generator.getSuccessResult();
    }


    // http://localhost:8984/role/delete/66
    @DeleteMapping("/deleteIds/{ids}")
    public RestResult deleteById(@PathVariable List<Long> ids) {
        deptService.removeByIds(ids);
        return generator.getSuccessResult();
    }

    @GetMapping("/edit/{id}")
    public String updateRole(@PathVariable Long id,Model model) {
        Dept role = deptService.getById(id);
        model.addAttribute("goat",role);
        return "role/roleEdit";
//        return generator.getSuccessResult(role);
    }





}
