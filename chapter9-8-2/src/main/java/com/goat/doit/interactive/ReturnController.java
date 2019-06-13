package com.goat.doit.interactive;


import com.goat.doit.common.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

/**
     * @Description: controller 返回 常见 数据类型 示例
     * @Date:   2018/9/13
*/
@RestController
@RequestMapping("/interactive/return")
public class ReturnController {

    /**
     返回   User  类型
     *      http://localhost:8982/interactive/return/test
     */
    @RequestMapping("/test")
    public User test(){
        return new User(1,"goat");
    }

    /**
     * 返回    List<User>  类型
     *  http://localhost:8982/interactive/return/findAll
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = new ArrayList<>(3);
        users.add(new User(1,"goat"));
        users.add(new User(2,"haha"));
        return users;
    }
    /**
     *  返回   Map  类型
     *  http://localhost:8982/interactive/return/map
     */
    @RequestMapping("/map")
    public Map map(){
        Map map = new HashMap();
        map.put("id",1);
        map.put("name","goat");
        map.put("age",12);
        return map;
    }
    /**
     *  返回   Map<String,Object>  类型
    http://localhost:8982/interactive/return/map2
     */
    @RequestMapping("/map2")
    public Map<String,Object> map2(){
        Map<String,Object> map = new HashMap();
        map.put("id",2);
        map.put("name","goat");
        map.put("age",12);
        return map;
    }

    /**
     *  返回   List<Map<String,Object>>  类型
    http://localhost:8982/interactive/return/listmap
     */
    @RequestMapping("/listmap")
    public List<Map<String,Object>> listmap(){
        Map<String,Object> map = new HashMap();
        map.put("id",3);
        map.put("name","goat");
        map.put("age",132);

        List<Map<String,Object>> temp = new ArrayList<>();
        temp.add(map);
        temp.add(map);
        return temp;
    }

    /**
     *  返回   MesDto  类型
    http://localhost:8982/interactive/return/MesDto
     */
    @RequestMapping("/MesDto")
    public MesDto MesDto(){
        Map<String,Object> map = new HashMap();
        map.put("id",1);
        map.put("name","goat");
        map.put("age",12);
        MesDto mesDto = new MesDto();
        mesDto.setMessage(map);
        mesDto.setResult(true);
        return mesDto;
    }
}
