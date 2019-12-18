

#  报错： ORA-00001: 违反唯一约束条件 自增序列
    new 实体类后  进行save操作后 出现的
    那个reel_id表 用在其他正式库中导入到测试库中 可能因此导致 主键自增序列打乱
    导致的生成的主键id 已经存在 在插入数据是 才报错的
    解决方法：
    在实体类主键的注解  增加 allocationSize=1 
    @SequenceGenerator(name = "DEFAULT_SEQ", sequenceName = "DEFAULT_SEQ",allocationSize=1)
    
    解释：
    oracle数据库中设置了自增，代码里也设置了allocationSize，具体的当前序列号为：
    当前序列号 = （数据库序列+数据库步长）*allocationSize
    allocationSize默认为50
    
    
# ORA-02289: 序列不存在

    create sequence DEFAULT_SEQ
    minvalue 2000
    maxvalue 9999999999
    start with 2020
    increment by 1
    cache 20;
    
    select DEFAULT_SEQ.nextval from dual;