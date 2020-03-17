package com.goat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @Description:  MockMvc 基于SpringMVC进行测试
 * @author: Goat
 * @Date:   2018/11/8
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //开启MockMvc  否则报错 No qualifying bean of type 'org.springframework.test.web.servlet.MockMvc' available
public class ApplicationTests {

    @Autowired
    private MockMvc mvc; //注入 MockMvc

    RequestBuilder request ;

    @Test
    public void test0() throws Exception {
        mvc.perform(get("/hello/findAll")) //请求方式： get   请求url： /hello/findAll
                .andDo(print()) //打印效果
                .andExpect(status().isOk()) //预期状态
                .andExpect(content().string(containsString("Hello World")));//预期返回值
    }


    @Test
    public void test1() throws Exception{  // 1、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andDo(print()) //打印效果
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    public void test2() throws Exception{   // 2、post提交一个user
        request = post("/users/")
                .param("id", "1")
                .param("name", "测试大师")
                .param("age", "20");
        mvc.perform(request)
                .andDo(print()) //打印效果
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void test3() throws Exception{     // 3、get获取user列表，应该有刚才插入的数据
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));
    }

    @Test
    public void test4() throws Exception{     // 4、put修改id为1的user
        request = put("/users/1")
                .param("name", "测试终极大师")
                .param("age", "30");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void test5() throws Exception{      // 5、get一个id为1的user
        request = get("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));
    }

    @Test
    public void test6() throws Exception{     // 6、del删除id为1的user
        request = delete("/users/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));
    }

    @Test
    public void test7() throws Exception{    // 7、get查一下user列表，应该为空
        request = get("/users/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }



}
