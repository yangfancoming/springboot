package com.goat.test;

import com.goat.chapter001.entity.User;
import com.goat.utils.RestBaseTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("post")
public class PostTest extends BaseTest{

    /**---------------------------postForEntity-----------------------------*/

    /**
     方法的第一参数表示要调用的服务的地址
     方法的第二个参数表示上传的参数
     方法的第三个参数表示返回的消息体的数据类型
    */
    //post 请求,提交 UserEntity 对像  http://localhost:8273/post/saveUser?username=itguang&password=123456&age=20&email=123@123.com
    @RequestMapping("saveUser")
    public String save(User user) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/save", user, String.class);
        String body = responseEntity.getBody();
        return body;
    }

    // 有参数的 postForEntity 请求
    @RequestMapping("saveUserByType/{type}")
    public String save2(User user,@PathVariable("type")String type) {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", user, String.class, type);
        String body = responseEntity.getBody();
        return body;
    }

    // 有参数的 postForEntity 请求,使用map封装
    @RequestMapping("saveUserByType2/{type}")
    public String save3(User user,@PathVariable("type")String type) {
        HashMap<String, String> map = new HashMap<>();
        map.put("type", type);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost/saveByType/{type}", user, String.class,map);
        String body = responseEntity.getBody();
        return body;
    }


    /**---------------------------getForObject-----------------------------*/
    /**
     如果你只关注，返回的消息体，可以直接使用postForObject。用法和 getForObject 一致。
     */
    @RequestMapping("test1")
    public User test1(User user) {
        User temp = restTemplate.postForObject("http://localhost/save", user, User.class);
        return temp;
    }


    // http://localhost:8273/post/fuck
    @RequestMapping("fuck")
    public void fuck() {
        try {
            ignoreSSL();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        String url = "https://etax.jiangsu.chinatax.gov.cn/portal/queryapi/query.do";
        Map<String, Object> params = new HashMap<>();
        params.put("action","authYshdSms");

//        {action=authYshdSms, data=
//                e6d98Tj5LGAwGdfqxKE5hsIk3ZqJG2610PKNj3V/pfPqh2CMWA+LULSH54fviW8iwkKzo2Avwh8sea945fX+3+hhFuIBeh5JgXGxugGf+rcEB3Nsyx2JwumuhcTnhc4Pf7sYVIOMtSvHUuGlPBjudpda6wjfn9QhoxE/PmIPNLRWxRK2DJQBqU}
//
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("shxydm","91310109MA1G525673");
//        data.put("sqrdm","10");
//        data.put("sqry_sfzjhm","320200000000000000");
//        data.put("sqry_sjhm","13770000000");
//        params.put("data",data);
        params.put("data","e6d98Tj5LGAwGdfqxKE5hsIk3ZqJG2610PKNj3V/pfPqh2CMWA+LULSH54fviW8iwkKzo2Avwh8sea945fX+3+hhFuIBeh5JgXGxugGf+rcEB3Nsyx2JwumuhcTnhc4Pf7sYVIOMtSvHUuGlPBjudpda6wjfn9QhoxE/PmIPNLRWxRK2DJQBqU");
        String s = restTemplate.postForObject(url, params, String.class);
        System.out.println(s);

    }


    public static void ignoreSSL() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = new TrustManager[]{new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) {}

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) {}

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        }};
        sslContext.init(null, trustManagers, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }



}
