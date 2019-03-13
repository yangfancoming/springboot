package com.goat.easyui.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.goat.easyui.domain.Role;

/**
 * 演示 mapper 父类，注意这个类不要让 mp 扫描到！！
 */
public interface SuperMapper<T> extends BaseMapper<T> {

    Page<Role> findByPage();
}
