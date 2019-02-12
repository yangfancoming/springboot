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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
public class MockMvcPutTest {

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
    public void requestBodyString() throws Exception {
        User user = new User("111","222");
        String requestJson = JSONObject.toJSONString(user);
        //  content 输入参数
        String responseString = mockMvc.perform(put("/users/1").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }



}
