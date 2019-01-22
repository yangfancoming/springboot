package com.goat.common;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 64274 on 2018/12/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/19---18:53
 */

@Service
public class CommonNativeSqls {

    @PersistenceContext
    private EntityManager entityManager;
    /**
     * @Title：  类型转换报错：  java.lang.ClassCastException: java.math.BigDecimal cannot be cast to java.lang.String
     * @author fan.yang
     * @date 2018年10月22日19:21:43
     * @return 返回
     */
    @SuppressWarnings("unchecked")
    public String test() {
        String sql = "SELECT sum(col2) FROM t_my_able";
        Query query = entityManager.createNativeQuery(sql); //
        List<String> resultList = query.getResultList();
        if(resultList.size()>0){
            return resultList.get(0); // 类型转换报错
        }
        return "-1";
    }

    @SuppressWarnings("unchecked")
    public Long test1() {
        String sql = "SELECT sum(col2) FROM t_my_table";
        Query query = entityManager.createNativeQuery(sql); //
        List<BigDecimal> temp =  query.getResultList();
        if(temp.size()>0){
            return temp.get(0).longValue(); // 正解
        }
        return -1L;
    }
}
