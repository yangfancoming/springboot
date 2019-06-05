package com.goat.controller;

import com.goat.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 64274 on 2018/10/16.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/16---19:43
 */

@RestController
@RequestMapping("/test")
public class TestController {


    // 测试地址：    http://localhost:8208/8208/test/savaUser1
    /**
     *  1、直接把表单的参数写在Controller相应的方法的形参中，适用于get方式提交，不适用于post方式提交。
     *  http://localhost:8888/test/savaUser?username=lixiaoxi&password=111111 提交的参数需要和Controller方法中的入参名称一致。
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/savaUser1")
    public String savaUser1(HttpServletRequest request,String username,String password) {
         //  + request.getRemoteHost() + request.getRemotePort() + request.getRemoteUser()
        System.out.println(request.getRemoteAddr()); // 127.0.0.1
        System.out.println(request.getRemoteHost()); // 127.0.0.1
        System.out.println(request.getRemotePort()); // 14575  24446  随机端口
        System.out.println(request.getRemoteUser()); // null
        return username + password;
    }

    /**
     * 2、通过HttpServletRequest接收，post方式和get方式都可以。
     * @param request
     * @return
     */
    @RequestMapping("/savaUser2")
    public String addUser2(HttpServletRequest request) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        return username + password ;
    }

    /**
     * 3、通过一个bean来接收,post方式和get方式都可以 建立一个和表单中参数对应的bean
     * @param user
     */
    @RequestMapping("/addUser3")
    public User addUser3(User user) {
        return user;
    }
    /**
     * 4、通过@PathVariable获取路径中的参数
     * 访问http://localhost/SSMDemo/demo/addUser4/lixiaoxi/111111 路径时，
     * 则自动将URL中模板变量{username}和{password}绑定到通过@PathVariable注解的同名参数上，
     * 即入参后username=lixiaoxi、password=111111。
     * @param username
     * @param password
     */
    @GetMapping(value="/addUser4/{username}/{password}")
    public String addUser4(@PathVariable String username,@PathVariable String password) {
        return username + password;
    }

    /**
     * 5、使用@ModelAttribute注解获取POST请求的FORM表单数据
     * @param user
     * @return
     */
    @PostMapping(value="/addUser5")
    public String addUser5(@ModelAttribute("user") User user) {
        return  user.getUsername() + user.getPassword();
    }
    /**
     * 6、用注解@RequestParam绑定请求参数到方法入参
     * 当请求参数username不存在时会有异常发生,可以通过设置属性required=false解决
     * @param username
     * @param password
     * @return
     */
    @ApiOperation(value="我的测试", notes="返回用户实体类")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true,   dataType = "query") })
    @GetMapping(value="/addUser6")
    public String addUser6(@RequestParam("username") String username,@RequestParam("password") String password) {
        return username + password;
    }

    @RequestMapping("/addUserJson")
    public String addUserJson(@RequestBody String user) {
        return user;
    }

    @RequestMapping("/addUserJson2")
    public List<User> addUserJson2(@RequestBody List<User> users) {
        return users;
    }


}
