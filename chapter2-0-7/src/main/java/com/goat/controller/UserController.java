package com.goat.controller;

import com.goat.bean.User;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/list")
    public List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(111,"111"));
        users.add(new User(222,"222"));
        return users;
    }

    // 如果请求中没有 username 参数 则报错：  Required String parameter 'username' is not present
//    @JsonView(User.UserSimpleView.class) // 根据注解 没有返回 password 字段属性  只返回一个 username 属性
    @PostMapping("/user1")
    public List<User> user1(@RequestParam String username){
        List<User> users = new ArrayList<>();
        users.add(new User(111,username,"1111"));
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        User temp = new User(id,"455","111");
        return temp;
    }

    @PostMapping("/{id}")
    public Map getMapById(@PathVariable Integer id){
        Map mapById = new HashMap(16);
        mapById.put(1,"111");
        mapById.put(2,"222");
        return mapById;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable Integer id){
        return false;
    }

    @PostMapping("/save1")
    public Boolean savaUser(){
        return false;
    }

    /**
     * 5、使用@ModelAttribute注解获取POST请求的FORM表单数据
     * @param user
     */
    @PostMapping("/save2")
    public Boolean postUser(@ModelAttribute User user) {  // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        return false;
    }

    @ModelAttribute
    public void ModelAttributeTest(@RequestParam(value = "id",required = false)Integer id,Map<String,Object> map) {
        System.out.println("你能看到我吗？");
        map.put("user",new User(111,"111"));
    }

    @PutMapping("/update")
    public Boolean updateUser(User user){
        return false;
    }

}
