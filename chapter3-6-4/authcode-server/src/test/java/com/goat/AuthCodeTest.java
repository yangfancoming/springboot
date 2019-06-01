package com.goat;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthCodeTest {



    public final static Integer PORT = 3641;
    public final static String CLIENT_ID = "clientapp";
    public final static String CLIENT_SECRET = "112233";
    public final static String CODE = "cESfM4";
    public final static String GRANT_TYPE = "authorization_code";
    public final static String REDIRECT_URI = "http://localhost:9001/callback";
    public final static String SCOPE = "read_userinfo";
    //登录地址
    final static String SIGN_IN_URI = "http://127.0.0.1:" + PORT + "/login";
    //获取accessToken得URI
    final static String TOKEN_REQUEST_URI = "http://localhost:" + PORT + "/oauth/token?grant_type=" + GRANT_TYPE + "&code=" + CODE + "&redirect_uri=" + REDIRECT_URI + "&scope=" + SCOPE;

    RestTemplate rest = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    /**
     *     final static String WAHAHA = "http://localhost:" + PORT + "/oauth/token?grant_type=" + GRANT_TYPE + "&code=" + CODE + "&redirect_uri=" + REDIRECT_URI + "&scope=" + SCOPE;
     * 用户名密码模式   doit 为什么请求失败 403  401 400 ？
     * @throws Exception
     */
    @Test
    public void signInTest() throws IOException {
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "user1");
        params.add("password", "123456");
        params.add("grant_type", "password");
        params.add("scope", SCOPE);
        HttpEntity<?> entity1 = new HttpEntity(params, headers);
        ResponseEntity<String> result = rest.exchange("http://localhost:3641/oauth/token", HttpMethod.POST, entity1, String.class, new Object[]{null});
        System.out.println(result);

        JSONObject obj = new JSONObject();
        obj.put("username", "user1");
        obj.put("password", "123456");
        obj.put("grant_type", "password");
        obj.put("scope", SCOPE);
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials(CLIENT_ID, CLIENT_SECRET));
        CloseableHttpClient createDefault = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
//        HttpPost post = new HttpPost("http://localhost:3641/api/userinfo");
        HttpPost post = new HttpPost("http://localhost:3641/oauth/token");
        StringEntity entity = new StringEntity(obj.toString(),"utf-8");
        entity.setContentType("application/x-www-form-urlencoded");
        post.setEntity(entity);
        CloseableHttpResponse result2 = createDefault.execute(post);
        System.out.println(result2);

    }


    @Test
    public void test()   {
        headers.add("authorization", getBasicAuthHeader());
        String result = rest.getForObject("http://localhost:3641/api/userinfo",  String.class);
        System.out.println(result);
    }
/**  请求成功后  返回 内容
     {
     "access_token": "7f50f4d0-131c-4ae2-b532-67f7b7e9fc2f",
     "token_type": "bearer",
     "expires_in": 43145,
     "scope": "read_userinfo"
     }
*/
    @Test
    public void getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("authorization", getBasicAuthHeader());
        ResponseEntity<OAuth2AccessToken> resp = rest.postForEntity(TOKEN_REQUEST_URI, new HttpEntity<>(null, headers), OAuth2AccessToken.class);
        if (!resp.getStatusCode().equals(HttpStatus.OK)) {
            throw new RuntimeException(resp.toString());
        }
        OAuth2AccessToken t = resp.getBody();
        System.out.println(t);
    }


    private String getBasicAuthHeader() {
        String auth = CLIENT_ID + ":" + CLIENT_SECRET;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
        String authHeader = "Basic " + new String(encodedAuth);
//        String authHeader = "Basic Auth " + new String(encodedAuth);
        System.out.println("-------"+authHeader);
        return authHeader;
    }

    // 简化模式 ： 测试 可以进入 controller 中！  注意token 过期时间哦 ！
    @Test
    public void testController() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.add("authorization", "Bearer " + "0204f4dc-7485-4964-80bf-121b75fe861c");
        headers.add("authorization", "Bearer " + "Y2xpZW50YXBwOjExMjIzMw");
        ResponseEntity<String> resp = rest.postForEntity("http://localhost:3641/api/userinfo", new HttpEntity<>(null, headers), String.class);
        System.out.println(resp);
    }

}
