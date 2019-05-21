

# 有状态 Bean 和无状态 Bean 的对象区别
    1、有状态就是有数据存储功能。有状态对象(Stateful Bean)，就是有实例变量的对象，可以保存数据，是非线程安全的。在不同方法调用间不保留任何状态。 
    2、无状态就是一次操作，不能保存数据。无状态对象(Stateless Bean)，就是没有实例变量的对象.不能保存数据，是不变类，是线程安全的。
    
# Bean 的作用域
    在Spring Framework中，总共定义了6种bean 的作用域，其中有4种作用域只有当应用为web应用的时候才有效，并且Spring还支持自定义作用域。
    1.1 singleton作用域
    singleton作用域表示在整个Spring容器中一个bean定义只生成了唯一的一个bean实例，被Spring容器管理。所有对这个bean的请求和引用都会返回这个bean实例。
    singleton作用域是Spring中默认的作用域，可以在定义bean的时候指定或者不指定都可以
    
    1.2 prototype作用域
    prototype作用域表示的是一个bean定义可以创建多个bean实例，有点像一个类可以new多个实例一样。
    也就是说，当注入到其他的bean中或者对这个bean定义调用getBean()时，都会生成一个新的bean实例。
    作为规则，应该对所有有状态的bean指定prototype作用域，对所有无状态的bean指定singleton作用域。
    
    1.3 当singleton的bean依赖prototype的bean
    当singleton的bean依赖prototype的bean时，请注意，这个依赖关系是在实例化时候解析的，并且只解析一次。因此，每个依赖的prototype的bean都是一个新的bean实例。
    然而，如果一个singleton的bean想要在运行时，在每次注入时都能有一个新的prototype的bean生成并注入，这是不行的。因为依赖注入在初始化的时候只会注入一次。如果想要在运行时多次注入新的prototype的bean
    
    
    1.4 request、session、application、websocket作用域
    request、session、application、websocket作用域只有在web环境下才有用。