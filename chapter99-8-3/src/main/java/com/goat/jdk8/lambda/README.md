# lambda 表达式

    为什么需要 lambda
    在 java 中，我们无法将函数作为参数传递给另一个方法，也无法声明返回一个函数的方法。
    
    lambda的作用：
    传递行为，而不仅仅是值
    
    前置条件： 必须是函数式接口 才能使用 lambda 表达式
    函数式接口特征：
    1. 接口中标注了  @FunctionalInterface 注解
    2. 接口中只有一个抽象方法 会被编译器自动认识成函数式接口
    3. 接口中有一个抽象，同时包含了 Object类的其他抽象方法也会被识别成抽象接口
    
    
    
    lambda 三种编写方式：
    1. expression 单条语句表达式   不需要写 return 关键字，解析器会自动计算结果 并返回
    2. statement  语句块       通过 { } 包裹多条语句 如果是需要返回结果的接口，那么必须显示加上 return 关键字
    3. refrence   方法引用
        static方法的引用	ContainingClass::staticMethodName
        特定对象的方法的引用	containingObject::instanceMethodName
        特定类型的方法的引用	ContainingType::methodName
        构造器的引用	ClassName::new
        
        (args)->{body}
        
        
    应用场景： 应用于 匿名函数 和 闭包
        事件监听
        条件过滤
        启动线程
        对象排序
        动态代理
    