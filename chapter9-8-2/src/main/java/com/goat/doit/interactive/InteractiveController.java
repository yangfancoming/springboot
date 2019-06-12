package com.goat.doit.interactive;

import com.goat.doit.common.model.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/interactive")
public class InteractiveController {

    /** a 标签跳转 */
    @RequestMapping("/a")
    public String test1() {
        return "A 标签成功跳进controller ！";
    }


    /**
     * 成功接收 字符串
     * sos 这里的 String mark  必须要与 前台  ajax 中的 data: {  "mark":codes, } 中的  "mark"  对应发否则无法接收！
     * */
    @PostMapping("/string")
    public void string(String mark) {
        System.out.println(mark);
    }

    /**
     * 成功接收 字符串
     * http://localhost:8290/string/test2?name=111&pwd=222
     * sos  url 中的 变量名 必须 后台接收参数 变量名 一致 否则 无法接收！
     * */
    @RequestMapping("/string1")
    public void test2( String username, String password ){
        System.out.println(username + "-----------" + password);
    }

    /**  使用 HttpServletRequest 接收 字符串*/
    @RequestMapping("/string2")
    public void test3( HttpServletRequest req){
        System.out.println(req.getParameter("username") + "-----------" + req.getParameter("password"));
    }

    /**  使用 实体类 接收 字符串*/
    @RequestMapping("/string3")
    public void test4( User user){
        System.out.println(user.getUsername() + "-----------" + user.getPassword());
    }








    /** 成功接收 数组 */
    @RequestMapping("/array")
    public void test1(@RequestParam(value = "codes[]", required = false) List<String> codes) {  // 成功
        String[] codeArr = codes.toArray(new String[codes.size()]); // list 转  数组
        System.out.println(codeArr);
    }

    /**  数组接收的三种失败方式
     public void test2(String[] codes) {  } // 失败
     public void test3(List<String> codes) {  } // 失败
     @RequestMapping(value = "/test4",produces="text/html;charset=UTF-8")
     public void test4(@RequestParam("codes") String[] codes ) {  } // 失败
    */


}
