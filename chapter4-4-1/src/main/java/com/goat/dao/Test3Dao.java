package com.goat.dao;

import com.goat.model.Emp;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/8/26.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/26---1:39
 */
public interface Test3Dao {

    List<Emp> findForListObject(String emp);

    List<Map> findForListMap(String em);

    @MapKey("ENAME") // 告诉mybatis 封装这个map的时候 使用哪个属性作为map的key
    Map<String,Emp> findForListMap1(String em);

}
