# lambda 表达式
    前置条件： 必须是函数式接口 才能使用 lambda 表达式
    函数式接口特征：
    1. 接口中标注了  @FunctionalInterface 注解
    2. 接口中只有一个抽象方法 会被编译器自动认识成函数式接口
    3. 接口中有一个抽象，同时包含了 Object类的其他抽象方法也会被识别成抽象接口
    
    lambda 三种编写方式：
    1. expression 单条语句表达式   不需要写 return 关键字，解析器会自动计算结果 并返回
    2. statement  语句块       通过 { } 包裹多条语句 如果是需要返回结果的接口，那么必须显示加上 return 关键字
    3. refrence   方法引用
    