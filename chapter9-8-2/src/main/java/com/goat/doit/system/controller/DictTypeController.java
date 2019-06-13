package com.goat.doit.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.system.model.DictType;
import com.goat.doit.system.service.DictTypeService;
import com.goat.doit.util.PageUtil;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.system.vo.base.PageResultVo;
import com.goat.doit.system.vo.base.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** 字典类型*/
@Controller
@RequestMapping("/dictType")
public class DictTypeController {

    private String mark = "字典类型";

    @Autowired
    private DictTypeService dictTypeService;

    @PostMapping("/list")
    @ResponseBody
    public PageResultVo list(DictType dictType, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<DictType> list = dictTypeService.selectDictTypeList(dictType);
        PageInfo<DictType> pages = new PageInfo<>(list);
        return ResultUtil.table(list,pages.getTotal());
    }


    /*新增保存字典类型*/
    @PostMapping("/add")
    @ResponseBody
    public ResponseVo add(DictType dictType){
        int a = dictTypeService.insertDictType(dictType);
        return a>0 ? ResultUtil.success("添加"+ mark +"成功"):ResultUtil.error("添加"+ mark +"失败");
    }


    /*删除字典类型*/
    @GetMapping("/delete")
    @ResponseBody
    public ResponseVo delete(Long id) {
        int i = dictTypeService.deleteDictTypeById(id);
        return i>0 ? ResultUtil.success("删除"+ mark +"成功"):ResultUtil.error("删除"+ mark +"失败");
    }

    /*编辑跳转*/
    @GetMapping("/edit")
    public String detail(Model model, Long id) {
        DictType dictType = dictTypeService.selectDictTypeById(id);
        model.addAttribute("role", dictType);
        return "system/dict/type/detail";
    }

    /*编辑保存*/
    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo edit(@ModelAttribute("dictType") DictType dictType) {
        int i = dictTypeService.updateDictType(dictType);
        return i>0 ? ResultUtil.success("编辑"+ mark +"成功"):ResultUtil.error("编辑"+ mark +"失败");
    }

    /**
     * 修改字典类型
     */
    @GetMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        mmap.put("dict", dictTypeService.selectDictTypeById(dictId));
        return  "/edit";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        mmap.put("dict", dictTypeService.selectDictTypeById(dictId));
        mmap.put("dictList", dictTypeService.selectDictTypeAll());
        return "system/dict/data/data";
    }

    /**
     * 校验字典类型
     */
//    @PostMapping("/checkDictTypeUnique")
//    @ResponseBody
//    public String checkDictTypeUnique(DictType dictType)
//    {
//        String uniqueFlag = "0";
//        if (StringUtils.isNotNull(dictType))
//        {
//            uniqueFlag = dictTypeService.checkDictTypeUnique(dictType);
//        }
//        return uniqueFlag;
//    }
}
