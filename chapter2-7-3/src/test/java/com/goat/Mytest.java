package com.goat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest extends BaseClient {

//    @Autowired

    /**
     * 演示方法：public void delete(String url, Object... uriVariables)
     * 参数意义：
     * url：url地址
     * uriVariables：url地址参数，如果url地址上没有参数的，这个参数可以不填，uriVariables的传递和get、post的类似方法相同。
     * RestTemplate的其余两个delete请求方法和前面的get和post的对应方法使用类似，我们可以查看源码和前面的get、post方法的相应方法
     * 进行学习使用。
     * 注意：这里的delete方法没有获取任何响应，那么如果我们要获取响应咋个办呢？那就只有直用exchange方法来实现delete请求。
     */
    @Test
    public void testDelete(){
        String url = HOST +"/api-demo/user?name={name}&age={age}";
        Object[] arr = new Object[]{"rose", 10};
        restTemplate.delete(url,arr);
    }
}
