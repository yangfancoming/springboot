package com.goat.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.goat.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2018/12/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/30---10:46
 */

@Api(tags ="用户管理" ,description="用户管理相关功能API")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation(value="获取所有用户记录", notes="controller方法描述")
    @GetMapping
    public List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User("111","111"));
        users.add(new User("222","222"));
        users.add(new User("333","333"));
        return users;
    }

    @ApiOperation(value="新增一个用户", notes="controller方法描述")
    @ApiImplicitParams({@ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User") })
    @PostMapping
    public User user(@Valid @RequestBody User user){
        System.out.println(user);
        User temp = new User("123","455","111");
        temp.setBirthday(user.getBirthday());
        return temp;
    }

    // 如果请求中没有 username 参数 则报错：  Required String parameter 'username' is not present
    @JsonView(User.UserSimpleView.class) // 根据注解 没有返回 password 字段属性  只返回一个 username 属性
    @PostMapping("/user1")
    public List<User> user1(@RequestParam String username){
        List<User> users = new ArrayList<>();
        users.add(new User("111",username,"1111"));
        return users;
    }

    @JsonView(User.UserDetailView.class) // 根据注解 可以返回 password 字段属性
    @GetMapping("/{id}")
    public User getUserById(@PathVariable String id){
        User user = new User(id, "goat","1111");
        return user;
    }

}
