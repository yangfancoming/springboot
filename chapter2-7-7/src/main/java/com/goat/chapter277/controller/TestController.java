package com.goat.chapter277.controller;

import com.goat.chapter277.model.TranslateProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2020/3/19.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/19---13:55
 */
@RestController
public class TestController {

    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";

    @Autowired
    private TranslateProperties props;

    @Autowired
    private RestTemplate restTemplate;


    // {"from":"zh","to":"en","trans_result":[{"src":"\u5c71\u7f8a","dst":"Goat"}]}
    @GetMapping("test2")
    public void test2() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("q", "goat");
        requestBody.add("from", "EN");
        requestBody.add("to", "ZH");
        requestBody.add("appid", props.getAppid());
        requestBody.add("salt", String.valueOf(System.currentTimeMillis()));
        requestBody.add("sign", props.getSign());
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<Object> responseEntity = restTemplate.postForEntity(TRANS_API_HOST, requestEntity, Object.class);
        System.out.println(responseEntity.getBody());
    }
}
