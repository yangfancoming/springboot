package com.goat.easyui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.goat.easyui.domain.Dept;


public interface IDeptService extends IService<Dept> {

    Page findByPage(Integer pageNo, Integer pageSize);
}
