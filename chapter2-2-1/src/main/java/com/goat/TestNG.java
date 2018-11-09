package com.goat;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.goat.bean.School;
import com.goat.bean.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 64274 on 2018/7/27.
 13         json2JsonObject();//将Json字符串转换为JSONObject对象
 14         json2JavaBean();//将Json字符串转换为JavaBean对象
 15         json2JsonArray();//将Json字符串转换为JSONArray对象
 16         json2JavaBeanList();//将Json字符串转换为JavaBean的集合
 17         javaBean2Json();//将JavaBean转换为Json格式的数据
 18         javaBean2JsonObject();//将JavaBean转换为JSONObject对象
 19         json2ListInMap();//从Json字符串的Map中获取List对象
 20         list2JsonInMap();//将含list的Map对象转换为Json字符串
 */
public class TestNG {

    @Test
    public void json2JsonObject() {
        String s = "{\"name\":\"peter\"}";
        JSONObject object = JSON.parseObject(s);
        System.out.println(object.get("name"));
    }
    @Test
    public void json2JavaBean() {
        String s = "{\"id\":\"17051801\",\"name\":\"lucy\"}";
        User user = JSON.parseObject(s, User.class);
        System.out.println(user.getId());
        System.out.println(user.getName());
    }
    @Test
    public void json2JsonArray() {
        String s = "[{\"id\":\"17051801\",\"name\":\"lucy\"},{\"id\":\"17051802\",\"name\":\"peter\"}]";
        JSONArray array = JSON.parseArray(s);
        for (int i = 0; i < array.size(); i++) {
            //JSONArray中的数据转换为String类型需要在外边加"";不然会报出类型强转异常！
            String str = array.get(i)+"";
            JSONObject object = JSON.parseObject(str);
            System.out.println(object.get("name"));
        }
    }
    @Test
    public  void json2JavaBeanList() {
        String s = "[{\"id\":\"17051801\",\"name\":\"lucy\"},{\"id\":\"17051802\",\"name\":\"peter\"}]";
        List<User> list = JSON.parseArray(s, User.class);
        for (User user : list) {
            System.out.println(user.getName());
        }
    }

    @Test
    public static void javaBean2Json() {
        User user = new User("17051801", "lucy");
        String string = JSON.toJSONString(user);
        System.out.println(string);
    }
    @Test
    public static void javaBean2JsonObject() {
        User user = new User("17051801", "lucy");
        JSONObject json = (JSONObject) JSON.toJSON(user);
        System.out.println(json.get("id"));
    }
    @Test
    public static void json2ListInMap() {
        String s = "{json:[{id:\"17051801\",\"name\":\"lucy\"},{id:\"17051802\",\"name\":\"peter\"},{id:\"17051803\",\"name\":\"tom\"},{id:\"17051804\",\"name\":\"lily\"}]}";
        //将Json字符串转换为JSONObject对象,并取出list对象的值
        JSONObject object = JSON.parseObject(s);
        Object objArray = object.get("json");
        String str = objArray+"";
        //方式1:转换成JSONArray对象形式
        JSONArray array = JSON.parseArray(str);
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = JSON.parseObject(array.get(i)+"");
            System.out.println(obj.get("name"));
        }
        //方式2:转换成List<JavaBean>形式
        List<User> list = JSON.parseArray(str, User.class);
        for (User user : list) {
            System.out.println(user.getName());
        }
    }

    @Test
    public static void list2JsonInMap() {
        //方式1:构建一个带有list的JavaBean对象
        School school = new School();
        school.setId("1");
        school.setName("schoolA");

        User user1 = new User();
        user1.setId("17051801");
        user1.setName("lucy");
        User user2 = new User();
        user2.setId("17051802");
        user2.setName("peter");

        school.getStudents().add(user1);
        school.getStudents().add(user2);
        //将JavaBean对象转换成Json字符串
        String string1 = JSON.toJSONString(school);
        System.out.println(string1);

        //方式2:构建一个带有list的Map对象
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", "17051801");
        map1.put("name", "lucy");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", "17051802");
        map2.put("name", "peter");

        List<Map<String, Object>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "schoolA");
        map.put("students", list);
        //将map对象转换成Json字符串
        String string2 = JSON.toJSONString(map);
        System.out.println(string2);
    }
    @Test
    public void test() {
        String temp = "{\"_name\":\"123\",\"_class\":\"123\",\"_sid\":\"123\",\"_sex\":\"1\",\"_age\":123}";
        Map maps = (Map) JSON.parse(temp); // 这里 只能解析 json 不能解析其他数据类型！
        System.out.println(maps);
    }



}
