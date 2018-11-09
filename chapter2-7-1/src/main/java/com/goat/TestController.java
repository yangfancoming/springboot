package com.goat;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.goat.bean.User;
import com.goat.pojo.HttpClientResult;
import com.goat.utils.HttpClientUtils;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
     * @Description:  测试服务器 0-0-0 项目  TestController
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/22
*/
@ContextConfiguration(classes= Application.class)
public class TestController {

    //  @RequestMapping("/savaUser1")
    @Test
    public void savaUser1() throws Exception { // OK
        HttpClientUtils.doGet("http://127.0.0.1:8888/test/savaUser1?username=lixiaoxi&password=111111");
    }
    @Test
    public void savaUser1Post() throws Exception { // OK
        HttpClientUtils.doPost("http://127.0.0.1:8888/test/savaUser1?username=lixiaoxi&password=111111");
    }

    //  @RequestMapping("/savaUser2")
    @Test
    public void savaUser2() throws Exception { // OK
        HttpClientUtils.doGet("http://127.0.0.1:8888/test/savaUser2?username=lixiaoxi&password=111111");
    }
    @Test
    public void savaUser2Post() throws Exception { // OK
        HttpClientUtils.doPost("http://127.0.0.1:8888/test/savaUser2?username=lixiaoxi&password=111111");
    }

    //  @RequestMapping("/addUser3")
    @Test
    public void addUser3() throws Exception {  // OK
        Map<String, String> params = new HashMap<>();
        params.put("username","111");
        params.put("password","222");
        HttpClientResult result = HttpClientUtils.doGet("http://127.0.0.1:8888/test/addUser3",params);
        System.out.println(result);
    }
    @Test
    public void addUser3Get() throws Exception { // OK
        HttpClientUtils.doGet("http://127.0.0.1:8888/test/addUser3?username=lixiaoxi&password=111111");
    }
    @Test
    public void addUser3Post() throws Exception { // OK
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8888/test/addUser3?username=lixiaoxi&password=111111");
        System.out.println(result);
    }

    //  @RequestMapping("/addUser4")
    @Test
    public void addUser4() throws Exception { // OK
       HttpClientUtils.doGet("http://127.0.0.1:8888/test/addUser4/lixiaoxi/111111");
    }
    //  @RequestMapping("/addUser5")
    @Test
    public void addUser5() throws Exception { // OK
        Map<String, String> params = new HashMap<>();
        params.put("username","111");
        params.put("password","222");
        HttpClientResult result = HttpClientUtils.doPost("http://127.0.0.1:8888/test/addUser5",params);
        System.out.println(result);
    }

    //  @RequestMapping("/addUser6")
    @Test
    public void addUser6() throws Exception { // OK
         HttpClientUtils.doGet("http://127.0.0.1:8888/test/addUser6?username=lixiaoxi&password=111111");
    }
    @Test
    public void addUser61() throws Exception { // OK
        // Required String parameter 'username' is not present
        System.out.println(HttpClientUtils.doGet("http://127.0.0.1:8888/test/addUser6?&password=111111"));
    }
    @Test
    public void addUser62() throws Exception { // OK
        // Required String parameter 'password' is not present
        System.out.println(HttpClientUtils.doGet("http://127.0.0.1:8888/test/addUser6?username=lixiaoxi"));
    }

    //  @RequestMapping("/addUserJson")
    @Test
    public void addUserJson() throws Exception { // ok
        User user = new User("1111", "22222");
        JSONObject json = (JSONObject) JSON.toJSON(user);
        JSONObject result = HttpClientUtils.doPost("http://127.0.0.1:8888/test/addUserJson",json);
        System.out.println(result);
    }
    //  @RequestMapping("/addUserJson2")
    @Test
    public void addUserJson2() throws Exception { // ok
        User user1 = new User("1111", "22222");
        User user2 = new User("3333", "44444");
        List<User> users = new ArrayList<>(16);
        users.add(user1);
        users.add(user2);
        String json =  JSON.toJSONString(users);
        String result = HttpClientUtils.doPost("http://127.0.0.1:8888/test/addUserJson2",json);
        System.out.println(result);
    }
}
