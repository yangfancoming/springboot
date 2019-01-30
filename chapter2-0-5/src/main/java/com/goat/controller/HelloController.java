package com.goat.controller;


import com.goat.domain.MesDto;
import com.goat.domain.RestResponse;
import com.goat.domain.User;
import com.goat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


/**
     * @Description: 功能描述：   controller 返回 常见 数据类型 示例
     * @Date:   2018/9/13
*/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    /**
     返回   User  类型
     *      http://localhost:8080/hello/findById
     */
    @RequestMapping("/test")
    public User test(){
        User user = userRepository.findById(2L).get();
        return user;
    }


    /**
            返回   Optional<User>  类型
     *      http://localhost:8080/hello/findById
    */
    @RequestMapping("/findById")
    public Optional<User> hellola(){
        Optional<User> map = userRepository.findById(2L);
        return map;
    }
    /**
     * @Description: 功能描述： 返回    List<User>  类型
       http://localhost:8080/hello/findAll
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        return users;
    }
    /**
     * @Description: 功能描述： 返回   Map  类型
    http://localhost:8080/hello/map
     */
    @RequestMapping("/map")
    public Map map(){
        Map map = new HashMap();
        map.put("id",1);
        map.put("name","fuck");
        map.put("age",12);
        return map;
    }
    /**
     * @Description: 功能描述： 返回   Map<String,Object>  类型
    http://localhost:8080/hello/map2
     */
    @RequestMapping("/map2")
    public Map<String,Object> map2(){
        Map<String,Object> map = new HashMap();
        map.put("id",2);
        map.put("name","fuck");
        map.put("age",12);
        return map;
    }

    /**
     * @Description: 功能描述： 返回   List<Map<String,Object>>  类型
    http://localhost:8080/hello/listmap
     */
    @RequestMapping("/listmap")
    public List<Map<String,Object>> listmap(){
        Map<String,Object> map = new HashMap();
        map.put("id",3);
        map.put("name","fuck");
        map.put("age",132);

        List<Map<String,Object>> temp = new ArrayList<>();
        temp.add(map);
        temp.add(map);
        return temp;
    }
    /**
     * @Description: 功能描述： 返回   RestResponse  类型
    http://localhost:8080/hello/RestResponse
     */
    @RequestMapping("/RestResponse")
    public RestResponse<Map<String, Object>> RestResponse(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","fuck");
        map.put("age",12);
        return RestResponse.ok(map);
    }

    /**
     * @Description: 功能描述： 返回   RestResponse  类型
    http://localhost:8080/hello/RestResponse2
     */
    @RequestMapping("/RestResponse2")
    public RestResponse<List<Map<String,Object>>> RestResponse2(){
        Map<String,Object> map = new HashMap();
        map.put("id",1);
        map.put("name","fuck");
        map.put("age",12);
        List<Map<String,Object>> temp = new ArrayList<>();
        temp.add(map);
        temp.add(map);
        return RestResponse.ok(temp);
    }

    /**
     * @Description: 功能描述： 返回   MesDto  类型
    http://localhost:8080/hello/MesDto
     */
    @RequestMapping("/MesDto")
    public MesDto MesDto(){
        Map<String,Object> map = new HashMap();
        map.put("id",1);
        map.put("name","fuck");
        map.put("age",12);
        MesDto mesDto = new MesDto();
        mesDto.setMessage(map);
        mesDto.setResult(true);
        return mesDto;
    }
}
