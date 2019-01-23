
# java 注解分类 
    按运行机制分
        1.源码注解 只在源码中存在
        2.编译时注解 在class中依然存在，如 @Deprecated @Override @SuppressWarnings
        3.运行时注解 运行阶段起作用，如 @Autowired
    按来源分
        1.JDK自带注解
        2.三方注解 最常见
        3.自定义注解
# 注解的定义：Java文件叫做Annotation，用@interface表示。
# 元注解：@interface上面按需要注解上一些东西，包括@Retention、@Target、@Document、@Inherited四种。
# 注解的作用目标：       
        @Target： 可能的ElementType参数有：
        ElementType  枚举常量
        TYPE_PARAMETER    @since 1.8
        TYPE_USE    @since 1.8
        
    　　@Target(ElementType.TYPE)             // 接口、类、枚举、注解
    　　@Target(ElementType.FIELD)            // 字段、枚举的常量
    　　@Target(ElementType.METHOD)           // 方法
    　　@Target(ElementType.PARAMETER)        // 方法参数
    　　@Target(ElementType.CONSTRUCTOR)      // 构造函数
    　　@Target(ElementType.LOCAL_VARIABLE)   // 局部变量
    　　@Target(ElementType.ANNOTATION_TYPE)  // 注解
    　　@Target(ElementType.PACKAGE)           // 包
#3.注解的保留策略：

        @Retention 表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：
    　　@Retention(RetentionPolicy.SOURCE)   // 注解仅存在于源码中，在class字节码文件中不包含，注解将被编译器丢弃
    　　@Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得(注解在class文件中可用，但会被VM丢弃)
    　　@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到( RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息)
            
           