package com.goat;


import org.apache.commons.codec.binary.Base64;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest {



    public final static Integer PORT = 3641;
    public final static String CLIENT_ID = "clientapp";
    public final static String CLIENT_SECRET = "112233";
    public final static String CODE = "1D1LCZ";
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
     * 用户名密码登录  doit 为什么请求失败 403 ？
     * @throws Exception
     */
    @Test
    public void signInTest()   {

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.add("authorization", getBasicAuthHeader());
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "user1");
        params.add("password", "123456");
        HttpEntity<?> entity = new HttpEntity(params, headers);
        ResponseEntity<String> result = rest.exchange(SIGN_IN_URI, HttpMethod.POST, entity, String.class, new Object[]{null});
        System.out.println(result);
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
        System.out.println("-------"+authHeader);
        return authHeader;
    }

    // 测试 可以进入 controller 中！
    @Test
    public void testController() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("authorization", "Bearer " + "7f50f4d0-131c-4ae2-b532-67f7b7e9fc2f");
        ResponseEntity<String> resp = rest.postForEntity("http://localhost:3641/api/userinfo", new HttpEntity<>(null, headers), String.class);
        System.out.println(resp);
    }
}
