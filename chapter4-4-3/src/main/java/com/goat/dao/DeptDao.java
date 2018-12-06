package com.goat.dao;


import com.goat.bean.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Created by 64274 on 2018/8/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/21---20:51
 */
public  interface DeptDao {


    Dept findObjectById(Integer id);

    Map<String,Object>  dynamic1(Map map);
    Map<String,Object>  dynamic2(Map map);

    Dept findObjectBy2(Integer id,String dname);

    Dept findObjectBy22(@Param("id") Integer id,@Param("dname") String dname);

    Dept findObjectBy222(@Param("id") Integer id,@Param("dname") String dname);

}
