package com.goat.chapter277.controller;

import cn.goatool.core.util.DigestUtils;
import com.goat.chapter277.model.MyResult;
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

import java.nio.charset.StandardCharsets;

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

    @GetMapping("test1")
    public void test1() {
        String s = DigestUtils.md5DigestAsHex("123".getBytes(StandardCharsets.UTF_8));
        System.out.println(s);
    }

    // {"from":"zh","to":"en","trans_result":[{"src":"\u5c71\u7f8a","dst":"Goat"}]}
    @GetMapping("test2")
    public MyResult test2() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("q", props.getQ());
        requestBody.add("from", props.getFrom());
        requestBody.add("to", props.getTo());
        requestBody.add("appid", props.getAppid());
        requestBody.add("salt", props.getSalt());
        String src = props.getAppid() + props.getQ() + props.getSalt() + props.getSign();
        requestBody.add("sign", DigestUtils.md5DigestAsHex(src.getBytes(StandardCharsets.UTF_8)));
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<MyResult> responseEntity = restTemplate.postForEntity(TRANS_API_HOST, requestEntity, MyResult.class);
        MyResult body = responseEntity.getBody();
        return body;
    }
}
