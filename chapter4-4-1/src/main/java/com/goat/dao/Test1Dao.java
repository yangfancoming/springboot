package com.goat.dao;



import com.goat.model.Emp;

import java.util.Map;

/**
 * Created by 64274 on 2018/8/26.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/26---1:39
 */
public interface Test1Dao {
    Integer saveMap(Map map);
    Integer saveObject(Emp emp);
}
