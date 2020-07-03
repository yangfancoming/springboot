package com.goat.service.impl;

import com.goat.dao.EmpDao;
import com.goat.entity.Emp;
import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/8/20.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/20---17:48
 */
@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired
    EmpDao empDao;


    @Override
    public Map findMapById(Integer id) {
        Map map = empDao.findMapById(id);
        return map;
    }

    @Override
    public Map findMapById2(Integer id) {
        Map map = empDao.findMapById(id);
        return map;
    }

    @Override
    public List<Emp> findListLastNameLike(String name) {
        List<Emp> list = empDao.findListLastNameLike(name);
        return list;
    }

    @Override
    public Map<Integer, Emp> findListLastNameLike2(String name) {
        Map<Integer, Emp> list = empDao.findListLastNameLike2(name);
        return list;
    }
}
