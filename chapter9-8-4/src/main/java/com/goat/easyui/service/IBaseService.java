package com.goat.easyui.service;

import com.github.pagehelper.Page;

/**
 * Created by 64274 on 2019/3/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/13---16:13
 */
public  interface  IBaseService<T> {

    Page<T> findByPage(Integer pageNo, Integer pageSize);
}
