package com.goat.controller;


import com.goat.chapter001.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 用户API
 * @Date: Created in 2018/8/14  14:54
 */
@RestController
@RequestMapping("/get")
public class GetDemoController {

    private Logger logger = LoggerFactory.getLogger(GetDemoController.class);
    List<User> userList = new ArrayList<>();
    User user1 = new User("liutao","12","123");
    User user2 = new User("liubei","12","123");
    User user3 = new User("1","12","123");

    /**
     * 获取多个用户信息
     * @return
     */
    @GetMapping(value="/users")
    public List<User> getUsers(){
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }

    @RequestMapping("getById/{id}")
    public User getById(@PathVariable(name = "id") String id) {
        List<User> collect = userList.stream().filter(user->user.getId().equals(id)).collect(toList());
        if (collect != null && collect.size()>0){
            return collect.get(0);
        }
        return null;
    }

    /**
     * 获取单个用户信息
     * 将错误码和错误信息存放在header中进行传递
     * @return
     */
    @GetMapping("/user")
    public User getUser(
            @RequestParam(value = "name",defaultValue = "liutao")String name,
            @RequestParam(value = "age",defaultValue = "10") Integer age) {
        logger.debug("name:"+name+",age:"+age);
        User user = new User(name,age,"123");
        return user;
    }

    /**
     * 获取某个部门下的某个用户
     * 这里针对部门的限制使用了路径参数，使用PathVariable标签来获取部门信息
     * @param dept
     * @param name
     * @return
     */
    @GetMapping("/{dept}/user")
    public User getUserOfDept( @PathVariable("dept") String dept,@RequestParam(value = "name")String name,HttpServletRequest request){
        //获取到请求头的token，然后进行相关的认证逻辑
        String token = request.getHeader("token");
        logger.debug("token:"+token);
        logger.debug("dept:"+dept+",name:"+name);
        User user = new User(name,dept);
        return user;
    }


}
