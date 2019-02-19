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