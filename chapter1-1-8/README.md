# OGNL的要素
    
     OGNL有三大要素，分别是表达式、根对象、Context对象。
     
# MyBatis OGNL 表达式
     MyBatis中可以使用OGNL的地方有两处：
     1.动态SQL表达式中
     2.${param}参数中
     
     
# 
    ognl.Ognl类：这个类主要用来解析和解释执行Ognl表达式
    ognl.OgnlContext类：这个类为Ognl表达式提供了一个执行环境，这个类实现了Map接口，所以允许通过put(key,obj)方法向OgnlContext环境中方式各种类型的对象，
    需要注意的是在OgnlContext中对象分为两种，第一种是叫做root对象（根对象），在整个OgnlContext中有且最多只能有一个根对象，
    可以通过调用OgnlContext.setRoot(obj)设置为根对象，
    另外一种就是OgnlContext中的普通对象，这种个数类型不受限制，那么既然分为两种方式，肯定在获取对象属性的方式上是有所不同的
