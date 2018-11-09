package com.goat.service.impl;

import com.goat.dao.BaseDao;
import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public List<Map> findById(String id) {
        List<Map> map = baseDao.findById(id);
        return map;
    }

    @Override
    public Integer saveEmp(Integer EMPNO,String ENAME) {
        Integer temp = baseDao.saveEmp(EMPNO,ENAME);
        int i = 10/0;
        System.out.println(i);
        return temp;
    }

    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: 杨帆
     @Transactional 注解应该只被应用到 public 方法上，这是由 Spring AOP 的本质决定的。
     如果你在 protected、private 或者默认可见性的方法上使用 @Transactional 注解，
     这将被忽略，也不会抛出任何异常。
         * @Date:   2018/8/22
    */
    @Override
    @Transactional // 开启事务
    public Integer saveEmp2(Integer EMPNO,String ENAME) {
        Integer temp = baseDao.saveEmp2(EMPNO,ENAME);
        int i = 10/0;
        System.out.println(i);
        return temp;
    }
}
