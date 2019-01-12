package com.goat.testng;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goat.HttpClientApplication;
import com.goat.entity.User;
import com.goat.pojo.HttpClientResult;
import com.goat.utils.HttpClientUtils;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
     * @Description:  测试服务器 0-0-0 项目  TestControllerTest
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/22
*/
@ContextConfiguration(classes= HttpClientApplication.class)
public class TestControllerTest {

    private static final String url = "http://127.0.0.1:8208/8208";

    @Test
    public void testGet() throws Exception { // OK
        HttpClientResult httpClientResult = HttpClientUtils.doGet(url + "/user/savaUser1?username=lixiaoxi&password=111111");
        System.out.println(httpClientResult);
    }
    @Test
    public void testPost() throws Exception { // OK
        HttpClientResult httpClientResult = HttpClientUtils.doPost(url +"/user/save1?username=lixiaoxi&password=111111");
        System.out.println(httpClientResult);
    }

    @Test
    public void savaUser2() throws Exception { // OK
        HttpClientResult httpClientResult = HttpClientUtils.doGet(url + "/user/sava2?username=lixiaoxi&password=111111");
        System.out.println(httpClientResult);
    }

    @Test
    public void savaUser2Post() throws Exception { // OK
        HttpClientResult httpClientResult = HttpClientUtils.doPost(url + "/user/savaUser2?username=lixiaoxi&password=111111");
        System.out.println(httpClientResult);
    }

    @Test
    public void addUser3() throws Exception {  // OK
        Map<String, String> params = new HashMap<>();
        params.put("username","111");
        params.put("password","222");
        HttpClientResult result = HttpClientUtils.doGet(url +  "/user/addUser3",params);
        System.out.println(result);
    }
    @Test
    public void addUser3Get() throws Exception { // OK
        HttpClientUtils.doGet(url +  "/user/addUser3?username=lixiaoxi&password=111111");
    }
    @Test
    public void addUser3Post() throws Exception { // OK
        HttpClientResult result = HttpClientUtils.doPost(url + "/user/addUser3?username=lixiaoxi&password=111111");
        System.out.println(result);
    }

    @Test
    public void addUser4() throws Exception { // OK
       HttpClientUtils.doGet(url + "/user/addUser4/lixiaoxi/111111");
    }

    @Test
    public void addUser5() throws Exception { // OK
        Map<String, String> params = new HashMap<>();
        params.put("username","111");
        params.put("password","222");
        HttpClientResult result = HttpClientUtils.doPost(url + "/test/addUser5",params);
        System.out.println(result);
    }

    @Test
    public void addUser6() throws Exception { // OK
        HttpClientResult httpClientResult = HttpClientUtils.doGet(url + "/test/addUser6?username=lixiaoxi&password=111111");
        System.out.println(httpClientResult);
    }

    @Test
    public void addUser61() throws Exception { // OK
        // Required String parameter 'username' is not present     username和password  缺一个都不好使
        System.out.println(HttpClientUtils.doGet(url + "/test/addUser6?&password=111111"));
    }

    @Test
    public void addUserJson() throws Exception { // ok
        User user = new User("1111", "22222");
        JSONObject json = (JSONObject) JSON.toJSON(user);
        JSONObject result = HttpClientUtils.doPost(url + "/test/addUserJson",json);
        System.out.println(result);
    }

    @Test
    public void addUserJson2()   { // ok
        User user1 = new User("1111", "22222");
        User user2 = new User("3333", "44444");
        List<User> users = new ArrayList<>(16);
        users.add(user1);
        users.add(user2);
        String json =  JSON.toJSONString(users);
        String result = HttpClientUtils.doPost(url + "/test/addUserJson2",json);
        System.out.println(result);
    }
}
