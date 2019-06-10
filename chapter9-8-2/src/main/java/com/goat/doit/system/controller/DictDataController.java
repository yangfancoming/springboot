package com.goat.doit.system.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.system.model.DictData;
import com.goat.doit.system.service.DictDataService;
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

/**
 * 数据字典信息
 */
@Controller
@RequestMapping("/dictData")
public class DictDataController {

    private String mark = "字典数据";

    @Autowired
    private DictDataService dictDataService;


    @GetMapping("/test")
    public String dictData(Model model, String id){
        model.addAttribute("type", id);
        return "dict/data/list";
    }


    @PostMapping("/list")
    @ResponseBody
    public PageResultVo list(DictData dictData, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<DictData> dictList = dictDataService.finds(dictData.getDictType());
        PageInfo<DictData> pages = new PageInfo<>(dictList);
        return ResultUtil.table(dictList,pages.getTotal());
    }

    /*新增保存字典数据*/
    @PostMapping("/add")
    @ResponseBody
    public ResponseVo add(DictData dictData){
        int a = dictDataService.insertDictData(dictData);
        return a>0 ? ResultUtil.success("添加"+ mark +"成功"):ResultUtil.error("添加"+ mark +"失败");
    }

    /*删除字典类型*/
    @GetMapping("/delete")
    @ResponseBody
    public ResponseVo delete(Long id) {
        int i = dictDataService.deleteDictDataById(id);
        return i>0 ? ResultUtil.success("删除"+ mark +"成功"):ResultUtil.error("删除"+ mark +"失败");
    }

    /*编辑跳转*/
    @GetMapping("/edit")
    public String detail(Model model, Long id) {
        DictData dictData = dictDataService.selectDictDataById(id);
        model.addAttribute("role", dictData);
        return "dict/data/detail";
    }

    /*编辑保存*/
    @PostMapping("/edit")
    @ResponseBody
    public ResponseVo edit(@ModelAttribute("dictData") DictData dictData) {
        int i = dictDataService.updateDictData(dictData);
        return i>0 ? ResultUtil.success("编辑"+ mark +"成功"):ResultUtil.error("编辑"+ mark +"失败");
    }

    /**
     * 新增字典类型
     */
    @GetMapping("/add/{dictType}")
    public String add(@PathVariable("dictType") String dictType, ModelMap mmap)
    {
        mmap.put("dictType", dictType);
        return   "/add";
    }

    /**
     * 新增保存字典类型
     */
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(DictData dict)
//    {
//        return toAjax(dictDataService.insertDictData(dict));
//    }

    /**
     * 修改字典类型
     */
    @GetMapping("/edit/{dictCode}")
    public String edit(@PathVariable("dictCode") Long dictCode, ModelMap mmap)
    {
        mmap.put("dict", dictDataService.selectDictDataById(dictCode));
        return   "/edit";
    }

    /**
     * 修改保存字典类型
     */
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(DictData dict)
//    {
//        return toAjax(dictDataService.updateDictData(dict));
//    }

//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        return toAjax(dictDataService.deleteDictDataByIds(ids));
//    }
}
