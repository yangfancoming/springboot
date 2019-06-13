package com.goat.doit.interactive;

import com.goat.doit.common.model.User;
import com.goat.doit.common.util.GoatInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/interactive/receive")
public class ReceiveController {

    /** a 标签跳转 */
    @RequestMapping("/a")
    public String test1() {
        return "A 标签成功跳进controller ！";
    }

    /**
     * 成功接收 字符串
     *  测试地址： http://localhost:8982/interactive/string
     *  如果前后端参数名不匹配， 也可以进入controller方法 接收参数值为 null
     * sos 这里的 String mark  必须要与 前台  ajax 中的 data: {  "mark":codes, } 中的  "mark"  对应发否则无法接收！
     * */
    @PostMapping("/string")
    public void string(String mark) {
        System.out.println(mark);
    }

    /**
     * 测试地址： http://localhost:8982/interactive/user1?username=我的
     * 如果前后端参数名不匹配，则不会进入controller方法，并报错：
     There was an unexpected error (type=Bad Request, status=400).
     Required String parameter 'username' is not present
    */
    @GetMapping("/user1")
    public String user1(@RequestParam String username) throws UnsupportedEncodingException {
        String temp = URLDecoder.decode(username,"GBK"); // 如果前端发送的是GBK编码 则需要注这样进行转换
        return temp;
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
    public void test3(HttpServletRequest req){
        System.out.println(req.getParameter("username") + "-----------" + req.getParameter("password"));
    }

    /**  使用 实体类 接收 字符串*/
    @RequestMapping("/string3")
    public void test4( User user){
        System.out.println(user.getUsername() + "-----------" + user.getPassword());
    }


    /** 成功接收 数组
     * produces 不但可以设置返回值类型还可以设定返回值的字符编码；
     * produces = MediaType.APPLICATION_JSON_VALUE      指定 返回数据类型为 application/json  此处可以不写 因为 @RestController 就表明了 要返回 Json 类型
     * produces = MediaType.APPLICATION_JSON_UTF8_VALUE 指定 返回数据类型为  application/json  并指定返回数据编码为  charset=utf-8
     * */
    @RequestMapping(value = "/array",produces = MediaType.APPLICATION_JSON_VALUE)
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


//    http://localhost:8982/interactive/receive/123
    @GetMapping("/{id}")
    public void getUserById(@PathVariable Integer id){
        System.out.println("进入 GetMapping" + id);
    }


    @PostMapping("/{id}")
    public void getMapById(@PathVariable Integer id){
        System.out.println("进入 PostMapping" + id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        System.out.println("进入 DeleteMapping" + id);
    }

    @PutMapping("/{id}")
    public void savaUser(@PathVariable Integer id){
        System.out.println("进入 PutMapping" + id);
    }

    @RequestMapping("/form1") //
    public void form1(HttpServletRequest request) {
        Map map = request.getParameterMap();
        System.out.println(map);
    }

    @RequestMapping("/form2")
    public void form2(HttpServletRequest request) throws Exception {
        Map map = GoatInfo.getInfo(request);
        System.out.println(map);
    }

}
