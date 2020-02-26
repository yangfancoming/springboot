# OGNL的要素
    
     OGNL有三大要素，分别是表达式、根对象、Context对象。
     
     　　表达式：OGNL表达式是功能强大的表达式语言，何解？在ognl中想要执行取值，赋值，调用方法等等操作，你都需要用表达式表示。通过表达式，底层会解析出来你的想要操作。它支持链式结构
     
     　　根对象：即root对象，可以理解为OGNL的操作对象，表达式规定做什么，而该对象就指定对谁操作。OGNL叫做对象图导航语言，对象图就是以任意一个对象作为根，通过OGNL可以访问到与这个对象相关的其他对象。底层使用list集合做的。
     
     　　Context对象：其实就是OGNL的上下文环境。root对象也在OGNL的上下文环境里，底层是一个Map集合。该上下文环境规定了OGNL操作在“哪里进行”，注意访问context对象时候需要在表达式中加上#。
     
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
