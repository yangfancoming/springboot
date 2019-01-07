# java 注解分类 
    按运行机制分
        1.源码注解 只在源码中存在
        2.编译时注解 在class中依然存在，如 @Deprecated @Override @SuppressWarnings
        3.运行时注解 运行阶段起作用，如 @Autowired
    按来源分
        1.JDK自带注解
        2.三方注解 最常见
        3.自定义注解
        
        
        
        
        
        
        @Target： 可能的ElementType参数有：
        ElementType  枚举常量
        ANNOTATION_TYPE  注解类型声明
        CONSTRUCTOR      构造方法声明
        FIELD            字段声明（包括枚举常量）
        LOCAL_VARIABLE   局部变量声明
        METHOD              方法声明
        PACKAGE          包声明
        PARAMETER        参数声明
        TYPE             类、接口（包括注解类型）或枚举声明
        TYPE_PARAMETER    @since 1.8
        TYPE_USE    @since 1.8
        
        
        @Retention
        表示需要在什么级别保存该注解信息。可选的RetentionPolicy参数包括：
        SOURCE：注解将被编译器丢弃
        CLASS：注解在class文件中可用，但会被VM丢弃
        RUNTIME：VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息