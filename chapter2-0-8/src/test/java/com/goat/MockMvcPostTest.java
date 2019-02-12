package com.goat;

import com.alibaba.fastjson.JSONObject;
import com.goat.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
public class MockMvcPostTest {

    @Autowired
    private MockMvc mockMvc; //注入 MockMvc

    @Test
    public void user1() throws Exception {
        String responseString = mockMvc.perform(post("/user/user1").contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("username","goatlike")) //  添加请求参数
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    @Test
    public void requestBodyString() throws Exception {
        User user = new User(111,"222",null);
        user.setBirthday(new Date());
        String requestJson = JSONObject.toJSONString(user);
        //  content 输入参数
        String responseString = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }



}
