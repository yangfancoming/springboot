package com.goat.doit.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.model.DictType;
import com.goat.doit.service.DictTypeService;
import com.goat.doit.util.PageUtil;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.vo.base.PageResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据字典信息
 *
 * @author Rimon
 */
@Controller
@RequestMapping("/dictType")
public class DictTypeController
{
    private String prefix = "system/dict/type";

    @Autowired
    private DictTypeService dictTypeService;

//    @GetMapping()
//    public String dictType()
//    {
//        return prefix + "/type";
//    }

    @PostMapping("/list")
    @ResponseBody
    public PageResultVo list(DictType dictType, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<DictType> list = dictTypeService.selectDictTypeList(dictType);
        PageInfo<DictType> pages = new PageInfo<>(list);
        return ResultUtil.table(list,pages.getTotal());
    }


    /**
     * 新增字典类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字典类型
     */
//    @PostMapping("/add")
//    @ResponseBody
//    public AjaxResult addSave(DictType dict)
//    {
//        return toAjax(dictTypeService.insertDictType(dict));
//    }

    /**
     * 修改字典类型
     */
    @GetMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        mmap.put("dict", dictTypeService.selectDictTypeById(dictId));
        return prefix + "/edit";
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
