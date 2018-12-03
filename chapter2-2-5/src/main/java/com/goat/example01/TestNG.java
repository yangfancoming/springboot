package com.goat.example01;


import com.goat.InventoryPlanMsg;
import com.goat.bean.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
     * @Description: 功能描述：Gson 工具 常用方法
     * @author: 杨帆
     * @Date:   2018/9/13
User 类的成员变量名要和 json 中的key 一致，成员变量类型要和json中的value类型一致；并且要生成getter和setter方法

在项目选型的时候可以使用Google的Gson和阿里巴巴的FastJson两种并行使用，
如果只是功能要求，没有性能要求，可以使用google的Gson，
如果有性能上面的要求可以使用Gson将bean转换json确保数据的正确，使用FastJson将Json转换Bean
*/

public class TestNG {

    Gson gson = new Gson();
    HashMap<String, Object> map = new HashMap<>();
    @BeforeMethod
    public void before(){
        map.put("name", "mafly");
        map.put("age", "18");
        map.put("sex", null);
    }

    //    fromJson 将json字符串转为 单个 bean 对象
    @Test
    public void fromJson() {
        String s = "{\"name\":\"peter\",\"id\":\"2222\"}"; //  OK
//        String s = "{\"name\":\"peter\",\"id\":\"\"}"; //  OK
//        String s = "{\"name\":\"peter\",\"id\":}"; //  报错  Expected value at line 1 column 22 path $.id
        User user = gson.fromJson(s, User.class);
        System.out.println(user);
    }

    //  fromJson 将json字符串转为  数组 bean 对象
    @Test
    public void fromJson3() {
        String jsonstr = "[{\"name\":\"jack\",\"age\":18},{\"name\":\"alex\",\"age\":23},{\"name\":\"jane\",\"age\":15}]";
        User[] users = gson.fromJson(jsonstr, User[].class);
        System.out.println(users);
    }
//    对于数组类可以直接转。但对于集合类就必须要用TypeToken。它是gson提供的数据类型转换器，可以支持各种数据集合类型转换。
    @Test
    public void fromJson4() {
        String jsonstr = "[{\"name\":\"jack\",\"id\":18},{\"name\":\"alex\",\"id\":23},{\"name\":\"jane\",\"id\":15}]";
        ArrayList<User> users = gson.fromJson(jsonstr, new TypeToken<ArrayList<User>>(){}.getType());
        System.out.println(users);
    }
    @Test
    public void fromJ2son4() {
        String jsonstr = "[{\"name\":\"jack\",\"id\":18},{\"name\":\"alex\",\"id\":23},{\"name\":\"jane\",\"id\":15}]";
        List<User> users = gson.fromJson(jsonstr, new TypeToken<List<User>>(){}.getType());
        System.out.println(users);
    }

    /**
         * @Description:   对应 Long 类型 code属性 要么写正确 要么就不写默认转为null  否则报错
         * @author: 杨帆
         * @Return:   Caused by: java.lang.NumberFormatException: empty String
         * @Date:   2018/12/3
    */
    @Test
    public void fromJ2son5() {
//        String jsonstr = "[{\"name\":\"jack\",\"id\":18,\"code\":\"\"},{\"name\":\"alex\",\"id\":23},{\"name\":\"jane\",\"id\":15}]"; // error  java.lang.NumberFormatException: empty String
//        String jsonstr = "[{\"name\":\"jack\",\"id\":18,\"code\":15},{\"name\":\"alex\",\"id\":23},{\"name\":\"jane\",\"id\":15}]"; // OK 要么就写正确
//        String jsonstr = "[{\"name\":\"jack\",\"id\":18,\"code\":},{\"name\":\"alex\",\"id\":23},{\"name\":\"jane\",\"id\":15}]"; // error  Expected value at line 1 column 32 path $[0].code
        String jsonstr = "[{\"name\":\"jack\",\"id\":18},{\"name\":\"alex\",\"id\":23},{\"name\":\"jane\",\"id\":15}]"; // OK   要么就不写 code 属性 则 转换为 null
        List<User> users = gson.fromJson(jsonstr, new TypeToken<List<User>>(){}.getType());
        System.out.println(users);
    }

    //    toJson 将 单个 bean 对象转换为json字符串 **序列化 bean **
    @Test
    public void toJsonBean() {
        User user  = new User();
        user.setName("goat1");
        user.setId("1111");
        String jsonStr = gson.toJson(user, User.class);
        System.out.println(jsonStr);
    }

    //    toJson 将 多个bean对象转换为json字符串  **序列化 List **
    @Test
    public void toJsonListBean() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("111","name1"));
        users.add(new User("222","name2"));
        String jsonStr = gson.toJson(users);
//        String jsonStr = gson.toJson(users,ArrayList.class); // 也可以
        System.out.println(jsonStr);
    }


    // 该方法 会忽略掉 sex=null 属性
    @Test
    public void toJsonMap() {
        String jsonString = new Gson().toJson(map);
        System.err.println(jsonString);
    }

    // 该方法 不会忽略 sex=null 属性
    @Test
    public void toJsonMap2() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        String jsonString1 = gsonBuilder.serializeNulls().create().toJson(map);
        System.err.println(jsonString1);
    }

}
