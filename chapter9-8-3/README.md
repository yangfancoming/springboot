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
    
# org.apache.ibatis.builder.IncompleteElementException: Could not find result map com.goat.domain.Menu
# Caused by: java.lang.IllegalArgumentException: Result Maps collection does not contain value for com.goat.domain.Menu


# MyBatis中resultType和resultMap的区别
    MyBatis中在查询进行select映射的时候，返回类型可以用resultType，也可以用resultMap，resultType是直接表示返回类型的，而resultMap则是对外部ResultMap的引用，但是resultType跟resultMap不能同时存在。
    在MyBatis进行查询映射时，其实查询出来的每一个属性都是放在一个对应的Map里面的，其中键是属性名，值则是其对应的值。
    ①当提供的返回类型属性是resultType时，MyBatis会将Map里面的键值对取出赋给resultType所指定的对象对应的属性。所以其实MyBatis的每一个查询映射的返回类型都是ResultMap，只是当提供的返回类型属性是resultType的时候，MyBatis对自动的给把对应的值赋给resultType所指定对象的属性。
    ②当提供的返回类型是resultMap时，因为Map不能很好表示领域模型，就需要自己再进一步的把它转化为对应的对象，这常常在复杂查询中很有作用。
    
    
#  push 到 GitHub时报错：
    	Push failed: springboot: unable to access 'https://github.com/yangfancoming/springboot.git/': OpenSSL SSL_connect: SSL_ERROR_SYSCALL in connection to github.com:443
    	解决方法：
    	是因为Git的Http代理的问题，Git支持三种协议：git://、ssh://和http://，本来push的时候应该走ssh隧道的，但是因为设置了http代理，所以就走了http的代理，于是就提交不了了。 
        OK，找到原因了，那就取消http代理吧：  在命令行执行命令： git config --global --unset http.proxy 