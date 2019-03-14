//package com.goat.easyui.service.impl;
//
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;
//import com.goat.easyui.dao.SuperMapper;
//import com.goat.easyui.service.IBaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * Created by 64274 on 2019/3/13.
// *
// * @ Description: TODO
// * @ author  山羊来了
// * @ date 2019/3/13---16:14
// */
//public class BaseServiceImpl<T> implements IBaseService<T> {
//
//    @Autowired
//    SuperMapper superMapper;
//
//    /**
//     * 分页查询
//     * @param pageNo 页号
//     * @param pageSize 每页显示记录数
//     * @return
//     */
//    @Override
//    public Page<T> findByPage(Integer pageNo, Integer pageSize) {
//        PageHelper.startPage(pageNo,pageSize);
//        return superMapper.findByPage();
//    }
//}
