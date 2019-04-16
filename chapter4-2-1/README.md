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
    
# JPA 自动创建时间，修改时间。
    1.实体类加注解 注意 日期类型 为 Date 不能是 Timestamp   还要记得 增加对应的get set 方法
    
    /**  * 创建时间 */
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;
    
    /** * 修改时间 */
    @LastModifiedDate
    @Column(name = "modify_time")
    private Date modifyTime;
     
    2.实体类头加注解   @EntityListeners(AuditingEntityListener.class)
    
    3.SpringBoot启动类加注解  @EnableJpaAuditing
    
# 报错： javax.persistence.EntityNotFoundException: Unable to find com.goat.domain.Customer with id 2



# 外键 问题：
    Caused by: javax.persistence.EntityNotFoundException: Unable to find com.sim.wms.entity.Dictionary with id 310
    根本原因：由于后来加上的实体、对象在之前的数据没有关联上，所以造成脏数据、故根本的解决方法，就是将之前的测试数据删除，重新添加数据就行了。
    
    解决办法：
    　　1. 检查为什么子表中没有主表中ID对应的记录
    　　2. 如果子表中没有主表ID对应的记录也可以正常加载数据，那么需要在主表字段上加一个@NotFound Annotation



#报错：Parameter value element [null] did not match expected type [java.lang.String (n/a)]
        @Query(value = " from InoutStorage where code in :codes group by code")
        List<InoutStorage> findByInoutStorageCodeIn(@Param(value = "codes") List<String> codes);
        造成报错的根本原因在于：调用该方法时传入的参数 codes 中含有 null 值, 过滤掉 null 值后再次测试，未出现问题。