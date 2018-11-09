package com.goat.dao;

import com.goat.model.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by 64274 on 2018/8/26.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/26---1:39
 *
 *
 */
public interface Test2Dao {

    Emp findObject(Emp emp);
    Map findMap(Map map);
    Emp findObject1(Integer id,String name);
    Emp findObject2(Integer id,String name);
    Emp findObject3(@Param("EMPNO") Integer id, @Param("ENAME") String name);


}
