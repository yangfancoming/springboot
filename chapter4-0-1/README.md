
#
    对Access数据库采用的是odbc方式的连接,这样应该也只适应于windows系统
    关键代码是connection-properties: charSet=gbk这里使用的是springboot自带的连接池也就是tomcat7以后带的连接池,
    其他的连接池也应当有此方法,这个编码不写的话 查询都是乱码无法进行
    普通的JDBC代码如下
    
  