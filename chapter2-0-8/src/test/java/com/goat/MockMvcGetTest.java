package com.goat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
public class MockMvcGetTest {

    @Autowired
    private MockMvc mockMvc; //注入 MockMvc


    @Test
    public void user1() throws Exception {
        String responseString = mockMvc.perform(get("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("username","goatlike")) //  添加请求参数
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("goat"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }



}
