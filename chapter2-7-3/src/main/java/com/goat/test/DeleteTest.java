package com.goat.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 64274 on 2019/2/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/13---11:56
 */

@RestController
@RequestMapping("delete")
public class DeleteTest {
    protected static final String HOST = "http://localhost:8273";
    @Autowired
    RestTemplate restTemplate;


    /**
     * 演示方法：public void delete(String url, Object... uriVariables)
     * 参数意义：
     * url：url地址
     * uriVariables：url地址参数，如果url地址上没有参数的，这个参数可以不填，uriVariables的传递和get、post的类似方法相同。
     * RestTemplate的其余两个delete请求方法和前面的get和post的对应方法使用类似，我们可以查看源码和前面的get、post方法的相应方法
     * 进行学习使用。
     * 注意：这里的delete方法没有获取任何响应，那么如果我们要获取响应咋个办呢？那就只有直用exchange方法来实现delete请求。
     */
    @RequestMapping("/delete")
    public void delete() {
        restTemplate.delete("http://HELLO-SERVICE/getbook4/{1}", 100);
    }

    @RequestMapping("/delete2")
    public void delete2(){
        String url = HOST +"/api-demo/user?name={name}&age={age}";
        Object[] arr = new Object[]{"rose", 10};
        restTemplate.delete(url,arr);
    }

}
