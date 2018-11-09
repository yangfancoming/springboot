package com.goat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
     * @Description:  MockMvc 基于SpringMVC进行测试
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/11/8
*/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //开启MockMvc  否则报错 No qualifying bean of type 'org.springframework.test.web.servlet.MockMvc' available
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc; //注入 MockMvc

    @Test
    public void test1() throws Exception {
        mockMvc.perform(get("/hello/findAll")) //请求方式： get   请求url： /hello/findAll
                .andDo(print()) //打印效果
                .andExpect(status().isOk()) //预期状态
                .andExpect(content().string(containsString("Hello World")));//预期返回值
    }


}
