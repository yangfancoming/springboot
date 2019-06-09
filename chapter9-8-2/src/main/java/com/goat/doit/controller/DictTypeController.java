package com.goat.doit.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.model.DictType;
import com.goat.doit.service.DictTypeService;
import com.goat.doit.util.PageUtil;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.vo.base.PageResultVo;
import com.goat.doit.vo.base.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
     * 修改保存字典类型
     */
//    @PostMapping("/edit")
//    @ResponseBody
//    public AjaxResult editSave(DictType dict)
//    {
//        return toAjax(dictTypeService.updateDictType(dict));
//    }

//    @PostMapping("/remove")
//    @ResponseBody
//    public AjaxResult remove(String ids)
//    {
//        try
//        {
//            return toAjax(dictTypeService.deleteDictTypeByIds(ids));
//        }
//        catch (Exception e)
//        {
//            return error(e.getMessage());
//        }
//    }

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
