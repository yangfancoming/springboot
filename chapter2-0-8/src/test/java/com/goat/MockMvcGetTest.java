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
@AutoConfigureMockMvc
public class MockMvcGetTest {

    @Autowired
    private MockMvc mockMvc; //注入 MockMvc


    @Test
    public void user() throws Exception {
        //请求方式： post   请求url： /user    contentType 需要设置成 MediaType.APPLICATION_JSON，即声明是发送“application/json”格式的数据
        String responseString = mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期结果状态
                .andExpect(jsonPath("$.length()").value(3))  //预期结果 集合长度为3
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

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
