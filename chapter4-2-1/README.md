#  EntityManager 使用 
    1、hibernate 5.2 之后，SQLQuery.class、setResultTransformer方法已作废，其用法如下:
    
    Query query = entityManager.createNativeQuery(sql, clazz);
    query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    替换后为：
    
      Query query = entityManager.createNativeQuery(sql, clazz);
      query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);



    //    Transformers.ALIAS_TO_ENTITY_MAP //把输出结果转换成map
    //    Transformers.TO_LIST //把结果按顺序排进List
    //    ransformers.aliasToBean(target) //把结果通过setter方法注入到指定的对像属性中

# 表关系  
    单向 多对一 
    单向 一对多