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
        Map map = baseDao.findMapById(id);
        return map;
    }
}
