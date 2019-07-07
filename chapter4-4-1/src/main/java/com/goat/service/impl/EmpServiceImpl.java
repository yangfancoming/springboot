package com.goat.service.impl;

import com.goat.dao.BaseDao;
import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 64274 on 2018/8/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/20---17:48
 */
@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired BaseDao baseDao;


    @Override
    public Map findById(Integer id) {
        System.out.println(" 执行一次 findById.............");
        Map map = baseDao.findMapById(id);
        return map;
    }

    /**
        doit
     代码执行后 为什么会出现 ：JDBC Connection [com.mysql.jdbc.JDBC4Connection@2842781c] will not be managed by Spring  ？
     而且 for循环中 没有走 mybatis的缓存 而是查询3次 数据库？
    */
    @Override
    public void findById2(Integer id) {
        System.out.println(" 执行一次 findById2.............");
        for (int i = 0; i < 3; i++) {
            baseDao.findMapById(id);
        }
    }
}
