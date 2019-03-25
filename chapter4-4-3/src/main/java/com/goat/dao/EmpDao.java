package com.goat.dao;


import com.goat.entity.Emp;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/8/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/21---20:51
 */
public  interface EmpDao {

    Map findMapById(Integer id);

    List<Emp> findListLastNameLike(String name);

    @MapKey("empno") // 告诉mybatis 使用 Emp对象中的empno属性 作为 key
    Map<Integer, Emp> findListLastNameLike2(String name);

    Emp findObjectById(Integer id);

    Integer saveMap(Map map);

    Integer saveObject(Emp emp);

    Integer deleteById(Integer id);

    Integer updateMapById(Map emp);

    Integer updateObjectById(Emp emp);

}
