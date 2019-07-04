# spring.factories文件里每一个xxxAutoConfiguration文件一般都会有下面的条件注解:

    @ConditionalOnBean：当容器里有指定Bean的条件下
    @ConditionalOnClass：当类路径下有指定类的条件下
    @ConditionalOnExpression：基于SpEL表达式作为判断条件
    @ConditionalOnJava：基于JV版本作为判断条件
    @ConditionalOnJndi：在JNDI存在的条件下差在指定的位置
    @ConditionalOnMissingBean：当容器里没有指定Bean的情况下
    @ConditionalOnMissingClass：当类路径下没有指定类的条件下
    @ConditionalOnNotWebApplication：当前项目不是Web项目的条件下
    @ConditionalOnProperty：指定的属性是否有指定的值
    @ConditionalOnResource：类路径是否有指定的值
    @ConditionalOnSingleCandidate：当指定Bean在容器中只有一个，或者虽然有多个但是指定首选Bean
    @ConditionalOnWebApplication：当前项目是Web项目的条件下。
    上面@ConditionalOnXXX都是组合@Conditional元注解，使用了不同的条件Condition
    
    
    当一个 Bean 被 @Conditional 注解修饰时，Spring容器会对数组中所有 Condition 接口的 matches() 方法进行判断，
    只有当其中所有 Condition 接口的 matches()方法都为 ture 时，才会创建 Bean 。
    
#condition3
    切换两个配置属性  i18n.lang=en_US 和 i18n.lang=zh_CN
    看控制台 分别打印出不同的结果：
    com.goat.condition3.I18nEngImpl
    English   