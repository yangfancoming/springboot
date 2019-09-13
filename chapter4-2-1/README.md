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
    
# JPA 自动创建时间，修改时间 所需配置：
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
        
# JPA   一级缓存问题  spring boot jpa 查询缓存问题
    在一次请求过程中，查询一个对象数据出来后，做其他业务处理（这个业务逻辑需要几秒钟），这个时间可能别人修改了数据库内容（我不知道情况下）
    然后我重新查询一次数据（这个时候jpa并没有查询数据库，而是使用了缓存数据，）
    怎么解决这个问题，保证我在一次请求中，查询数据库都是新的数据，而不是缓存的？
    
    使用JPA方法 访问数据库 是会被一级缓存的
    但是在JPA中 使用原生sql 是不会被缓存的
    
    问题：在一个 for 循环中  第一次循环 使用 原生sql 更改一条记录  并不会更改缓存 
          循环第二次时 使用 JPA sql 查询那个条记录 因为走了缓存 所以 不会看到 原生sql 更改的结果
          
          
     解决方法： 
     1. 使用原生sql 查询  直接打库  不走缓存
     2. 别用原生sql 项目中 全部使用 JPA 方式操作数据库 
     
     
# 主键生成策略：
    JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
    TABLE：使用一个特定的数据库表格来保存主键。
    SEQUENCE(Oracle)：根据底层数据库的序列来生成主键，条件是数据库支持序列。  
    IDENTITY(mysql)：主键由数据库自动生成（主要是自动增长型）  
    AUTO：主键由程序控制(也是默认的,在指定主键时，如果不指定主键生成策略，默认为AUTO)
            
# JPA 映射视图实体类 需要注意的 
    这里主要说一下怎么用jpa映射一个视图的实体类，其实跟表映射一样，就是需要添加一个空的主键id标识
    @Entity
    @Table(name = "v_sc_template") // 这个是视图名称
    public class SupplyChainTemplate {
        @Id // 添加一个空的id标识，因为jpa在映射实体是需要一个id，这个必须
        @Column(name = "name")
        private String name;	   
        
        
     如果没有主键标识  则报错：To prevent a memory leak, the JDBC Driver has been forcibly unregistered.   
        