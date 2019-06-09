package com.goat.doit.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goat.doit.model.DictData;
import com.goat.doit.service.DictDataService;
import com.goat.doit.util.PageUtil;
import com.goat.doit.util.ResultUtil;
import com.goat.doit.vo.base.PageResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 数据字典信息
 * 
 * @author Rimon
 */
@Controller
@RequestMapping("/dictData")
public class DictDataController {

    private String prefix = "system/dict/data";

    @Autowired
    private DictDataService dictDataService;

    @GetMapping()
    public String dictData()
    {
        return prefix + "/data";
    }

    @PostMapping("/list")
    @ResponseBody
    public PageResultVo list(DictData dictData, Integer limit, Integer offset){
        PageHelper.startPage(PageUtil.getPageNo(limit, offset),limit);
        List<DictData> dictList = dictDataService.selectDictDataList(dictData);
        PageInfo<DictData> pages = new PageInfo<>(dictList);
        return ResultUtil.table(dictList,pages.getTotal());
    }


    /**
     * 新增字典类型
     */
    @GetMapping("/add/{dictType}")
    public String add(@PathVariable("dictType") String dictType, ModelMap mmap)
    {
        mmap.put("dictType", dictType);
        return prefix + "/add";
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
        return prefix + "/edit";
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
