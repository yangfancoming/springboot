package com.goat.webservice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2019/6/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/17---14:44
 */
@Service
public class AppServiceImpl implements AppService {

    @Autowired
    Cxfclient client;

    @Override
    public Object test(int a, int b) {
        return null;
    }

    @Override
    public String test2(String id) {
        return null;
    }


    @Override
    public Object fuck(int a, int b) {
        Object[] res = new Object[5];
        try {
            res = client.getClient().invoke("HelloWorld", a,b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res[0];
    }

    @Override
    public String getUserName(String id) {
        return null;
    }

    @Override
    public String getUser(String id) {
        return null;
    }

}
