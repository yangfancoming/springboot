package com.goat;

import com.alibaba.fastjson.JSONObject;
import com.goat.entity.Product;
import com.goat.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
     * @Description:  MockMvc 基于SpringMVC进行测试
     * @Date:   2018/11/8
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc; //注入 MockMvc

    @Test
    public void requestBodyString() throws Exception {
        User user = new User("111","2222");
        String requestJson = JSONObject.toJSONString(user);
        //请求方式： post   请求url： /request/requestBody    contentType需要设置成MediaType.APPLICATION_JSON，即声明是发送“application/json”格式的数据
        String responseString = mockMvc.perform(post("/test/requestBodyString").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    @Test
    public void requestBodyBean() throws Exception {
        String user = "{\"id\":\"17051801\",\"name\":\"lucy\"}";
        String responseString = mockMvc.perform(post("/test/requestBodyBean").contentType(MediaType.APPLICATION_JSON).content(user))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }


    /**
     *     public String error1(String name,Integer price,String category) {
     *     接收结果 全部为null
    */
    @Test
    public void error1() throws Exception {
        Product product = new Product("111",100,"2222");
        String requestJson = JSONObject.toJSONString(product);
        //请求方式： post   请求url： /request/requestBody    contentType需要设置成MediaType.APPLICATION_JSON，即声明是发送“application/json”格式的数据
        String responseString = mockMvc.perform(post("/test/error1").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    /**
     *        public String error2(@RequestBody Product product) {
     *     可以正确接收到参数
     */
    @Test
    public void error2() throws Exception {
        Product product = new Product("111",100,"2222");
        String requestJson = JSONObject.toJSONString(product);
        //请求方式： post   请求url： /request/requestBody    contentType需要设置成MediaType.APPLICATION_JSON，即声明是发送“application/json”格式的数据
        String responseString = mockMvc.perform(post("/test/error2").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    /**
     *        public String error2(@RequestBody Product product) {
     *     接收结果 全部为null
     */
    @Test
    public void error3() throws Exception {
        Product product = new Product("111",100,"2222");
        String requestJson = JSONObject.toJSONString(product);
        //请求方式： post   请求url： /request/requestBody    contentType需要设置成MediaType.APPLICATION_JSON，即声明是发送“application/json”格式的数据
        String responseString = mockMvc.perform(post("/test/error3").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }
}
