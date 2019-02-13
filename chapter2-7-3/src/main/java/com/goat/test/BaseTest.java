package com.goat.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 64274 on 2019/2/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/13---12:53
 */
public class BaseTest {

    protected static final String HOST = "http://localhost:8273";

    @Autowired RestTemplate restTemplate;

}
