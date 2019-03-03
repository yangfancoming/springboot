# LayUI
    layui.all.js 里面包含了 lay 文件夹下 所有的模块 
    如果使用lay文件夹下 具体的js模块  需要使用 use.('layer','laydate',function)
    
    
# mybatis plus 后台报错：
    org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.goat.dao.UserMapper.findUserWithRole
    即在mybatis中dao接口与mapper配置文件在做映射绑定的时候出现问题
    简单说，就是接口与xml要么是找不到，要么是找到了却匹配不到
    解决方法：将  mybatis-plus.mapper-locations=classpath:/mapper/*Mapper.xml  配置改成
    mybatis-plus.mapper-locations=classpath:/mapper/system/*Mapper.xml
    
    
    
# mybatis plus 后台报错：
     Cause: org.apache.ibatis.type.TypeException: Could not resolve type alias 'user'.  Cause: java.lang.ClassNotFoundException: Cannot find class: user
     解决方法： 将 UserMapper.xml 中 所有的 别名 user  
     更改为  
     resultType="com.goat.domain.User" 
     parameterType="com.goat.domain.User"
   
#  前后 接收是list  可是后台返回一个对象  就会这个错误！ 
    Uncaught TypeError: Cannot create property 'LAY_TABLE_INDEX' on number '4'