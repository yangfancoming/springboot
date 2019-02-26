#  Spring Retry支持集成到Spring或者Spring Boot项目中，而它支持AOP的切面注入写法，所以在引入时必须引入aspectjweaver.jar包。
 
     加入依赖 
             <dependency>
                 <groupId>org.springframework.retry</groupId>
                 <artifactId>spring-retry</artifactId>
             </dependency>
     
             <dependency>
                 <groupId>org.aspectj</groupId>
                 <artifactId>aspectjweaver</artifactId>
             </dependency>
             
             
    @Retryable注解
    被注解的方法发生异常时会重试 
    value：指定发生的异常进行重试 
    include：和value一样，默认空，当exclude也为空时，所有异常都重试 
    exclude：指定异常不重试，默认空，当include也为空时，所有异常都重试 
    maxAttemps：重试次数，默认3 
    backoff：重试补偿机制，默认没有
    
    
    @Backoff注解
    delay:指定延迟后重试 
    multiplier:指定延迟的倍数，比如delay=5000l,multiplier=2时，第一次重试为5秒后，第二次为10秒，第三次为20秒
    
    @Recover 
    当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调。


#采坑提示：
    1、由于retry用到了aspect增强，所有会有aspect的坑，就是方法内部调用，会使aspect增强失效，那么retry当然也会失效。参考改链接
    public class demo {
        public void A() {
            B();
        }
    
        //这里B不会执行
        @Retryable(Exception.class)
        public void B() {
            throw new RuntimeException("retry...");
        }
    }
    2、重试机制，不能在接口实现类里面写。所以要做重试，必须单独写个service。 
    
    
#说明：

    1、使用了@Retryable的方法不能在本类被调用，不然重试机制不会生效。也就是要标记为@Service，然后在其它类使用@Autowired注入或者@Bean去实例才能生效。
    2、要触发@Recover方法，那么在@Retryable方法上不能有返回值，只能是void才能生效。
    3、使用了@Retryable的方法里面不能使用try...catch包裹，要在发放上抛出异常，不然不会触发。
    4、在重试期间这个方法是同步的，如果使用类似Spring Cloud这种框架的熔断机制时，可以结合重试机制来重试后返回结果。
    5、Spring Retry不只能注入方式去实现，还可以通过API的方式实现，类似熔断处理的机制就基于API方式实现会比较宽松。