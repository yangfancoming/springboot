package com.goat.service;

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

    List<Map> findById(String id);

    Integer saveEmp(Integer EMPNO,String ENAME);

    Integer saveEmp2(Integer EMPNO,String ENAME);

    Integer saveEmp3(Integer EMPNO,String ENAME);
}
