package com.goat.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.goat.entity.User;
import com.goat.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



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


    @Reference
    public IUserService userService;

    @ApiOperation(value="获取所有用户记录", notes="controller方法描述")
    @GetMapping("/list")
    public List<User> users(){
        List<User> users = new ArrayList<>();
        users.add(new User(111,"111"));
        users.add(new User(222,"222"));
        users.add(new User(333,"333"));
        return users;
    }

    @ApiImplicitParams({@ApiImplicitParam(name = "user", value = "用户详细实体", required = true, dataType = "User") })
    @PostMapping
//    @JsonView(User.UserDetailView.class) // 根据注解 可以返回 password 字段属性
    public User user(@Valid @RequestBody User user){
        System.out.println(user);
        User temp = new User(123,"455","111");
        temp.setBirthday(user.getBirthday());
        return temp;
    }

    // 如果请求中没有 username 参数 则报错：  Required String parameter 'username' is not present
//    @JsonView(User.UserSimpleView.class) // 根据注解 没有返回 password 字段属性  只返回一个 username 属性
    @PostMapping("/user1")
    public List<User> user1(@RequestParam String username){
        List<User> users = new ArrayList<>();
        users.add(new User(111,username,"1111"));
        return users;
    }



    @ApiOperation(value="获取一个用户", notes="返回用户实体类")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id){
        User oldUser = userService.getById(id);
        return oldUser;
    }

    @ApiOperation(value="获取一个用户", notes="返回用户Map")
    @PostMapping("/{id}")
    public Map getMapById(@PathVariable Integer id){
        Map mapById = userService.findMapById(id);
        return mapById;
    }

    @ApiOperation(value="删除一个用户", notes="返回是否删除成功")
    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable Integer id){
        boolean b = userService.removeById(id);
        return b;
    }

    @ApiOperation(value="新增一个用户", notes="返回是否成功")
    @PostMapping("/save")
    public Boolean savaUser(User user){
        boolean b = userService.save(user);
        return b;
    }

    @ApiOperation(value="更新一个用户", notes="返回是否成功")
    @PutMapping("/update")
    public Boolean updateUser(User user){
        boolean b = userService.updateById(user);
        return b;
    }
}
