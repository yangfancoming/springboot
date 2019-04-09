package com.goat.entityManager;


import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TestNG3  {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String sql1 = "SELECT u.real_name AS createUser FROM t_warehouse_storage_content_msg m LEFT JOIN  t_user u ON m.add_user_id = u.id WHERE m.upn = :upn AND m.delete_state = 0 AND m.stock_count >0 ";
    private static final String sql2 = "SELECT  n.upn,n.initial_num AS initialNum ,n.supplier,n.lot_no AS lotNo," +
            "n.file_path AS filePath,n.file_name AS fileName,n.is_msd AS isMsd,n.msd_level AS msdLevel ," +
            "n.warning_num AS warningNum, n.real_date_code AS realDateCode,n.now_num AS nowNum " +
            "FROM t_upn n  WHERE n.upn = :upn";

    @Test
    public void findByUpn() {
//        String upn = "X00011000141601744";
        String upn = "X0001100014601744";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("upn", upn);// 输入sql中参数
        List<Map<String, Object>> temp1 = searchToListMap(sql1, paramMap);
        if(!temp1.isEmpty()){
            List<Map<String, Object>> temp2 = searchToListMap(sql2, paramMap);
            temp2.get(0).putAll(temp1.get(0));
        }
        System.out.println(temp1);
    }

    public List<Map<String, Object>> searchToListMap(String sql, Map<String, ? extends Object> paramMap){
        Query query = setParam(entityManager.createNativeQuery(sql), paramMap);
        query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    public Query setParam(Query query, Map<String, ? extends Object> paramMap){
        if (paramMap != null) {
            Set<String> mapSet = paramMap.keySet();
            for (String key : mapSet) {
                query.setParameter(key, paramMap.get(key));
            }
        }
        return query;
    }


}
