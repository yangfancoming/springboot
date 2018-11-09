package com.goat.controller;

import com.goat.bean.User;
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

    /**
     *  1、直接把表单的参数写在Controller相应的方法的形参中，适用于get方式提交，不适用于post方式提交。
     *  http://localhost:8888/test/savaUser?username=lixiaoxi&password=111111 提交的参数需要和Controller方法中的入参名称一致。
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/savaUser1")
    public String savaUser1(HttpServletRequest request,String username,String password) {
        System.out.println("username is:"+ username);
        System.out.println("password is:"+ password); //  + request.getRemoteHost() + request.getRemotePort() + request.getRemoteUser()
        System.out.println(request.getRemoteAddr()); // 127.0.0.1
        System.out.println(request.getRemoteHost()); // 127.0.0.1
        System.out.println(request.getRemotePort()); // 14575  24446  随机端口
        System.out.println(request.getRemoteUser()); // null
        return "demo/index";
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
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }

    /**
     * 3、通过一个bean来接收,post方式和get方式都可以 建立一个和表单中参数对应的bean
     * @param user
     * @return
     */
    @RequestMapping("/addUser3")
    public String addUser3(User user) {
        System.out.println("username is:"+user.getUsername());
        System.out.println("password is:"+user.getPassword());
        return "demo/index";
    }
    /**
     * 4、通过@PathVariable获取路径中的参数
     * 访问http://localhost/SSMDemo/demo/addUser4/lixiaoxi/111111 路径时，
     * 则自动将URL中模板变量{username}和{password}绑定到通过@PathVariable注解的同名参数上，
     * 即入参后username=lixiaoxi、password=111111。
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/addUser4/{username}/{password}",method= RequestMethod.GET)
    public String addUser4(@PathVariable String username,@PathVariable String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }

    /**
     * 5、使用@ModelAttribute注解获取POST请求的FORM表单数据
     * @param user
     * @return
     */
    @RequestMapping(value="/addUser5",method=RequestMethod.POST)
    public String addUser5(@ModelAttribute("user") User user) {
        System.out.println("username is:"+user.getUsername());
        System.out.println("password is:"+user.getPassword());
        return "demo/index";
    }
    /**
     * 6、用注解@RequestParam绑定请求参数到方法入参
     * 当请求参数username不存在时会有异常发生,可以通过设置属性required=false解决
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/addUser6",method=RequestMethod.GET)
    public String addUser6(@RequestParam("username") String username,@RequestParam("password") String password) {
        System.out.println("username is:"+username);
        System.out.println("password is:"+password);
        return "demo/index";
    }

    @RequestMapping("/addUserJson")
    public void addUserJson(@RequestBody String user) {
        System.out.println("username is:"+user);
    }
    @RequestMapping("/addUserJson2")
    public void addUserJson2(@RequestBody List<User> users) {
        System.out.println("username is:"+users);
    }



}
