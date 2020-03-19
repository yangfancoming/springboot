package com.goat.chapter277.handler;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;


/**
 * Created by 64274 on 2019/2/13.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/13---13:38
 */
@Component
public class CustomErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) {
        System.out.println("RestTemplate handlerError!!!!!!!!!!!!!!!!!!!!!!!!");
    }

}
