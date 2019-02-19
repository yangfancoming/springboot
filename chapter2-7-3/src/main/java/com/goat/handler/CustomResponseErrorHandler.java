package com.goat.handler;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;


/**
 * Created by 64274 on 2019/2/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/19---10:15
 */
public class CustomResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response)   {
        System.out.println("进入。。hasError。。。CustomResponseErrorHandler");
        return false;
    }


    @Override
    public void handleError(ClientHttpResponse response)   {
        System.out.println("进入。。handleError。。。CustomResponseErrorHandler");
    }
}
