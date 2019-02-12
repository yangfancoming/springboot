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
public class ApplicationTests {

    @Autowired
    private MockMvc mockMvc; //注入 MockMvc

    @Test
    public void requestBodyString() throws Exception {
        User user = new User("111","2222");
        String requestJson = JSONObject.toJSONString(user);
        //请求方式： post   请求url： /request/requestBody    contentType需要设置成MediaType.APPLICATION_JSON，即声明是发送“application/json”格式的数据
        String responseString = mockMvc.perform(post("/request/requestBodyString").contentType(MediaType.APPLICATION_JSON).content(requestJson))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

    @Test
    public void requestBodyBean() throws Exception {
        String user = "{\"id\":\"17051801\",\"name\":\"lucy\"}";
        String responseString = mockMvc.perform(post("/request/requestBodyBean").contentType(MediaType.APPLICATION_JSON).content(user))
                .andDo(print()) //打印效果
                .andExpect(status().isOk())  //预期状态
                .andReturn().getResponse().getContentAsString();
        System.out.println(responseString);
    }

}
