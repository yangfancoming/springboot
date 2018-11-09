package com.goat.service;


import com.goat.bean.Emp;

import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/8/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/20---17:48
 */
public interface IEmpService {

    Map findById(String id);

    List<Emp> findAll();
}
