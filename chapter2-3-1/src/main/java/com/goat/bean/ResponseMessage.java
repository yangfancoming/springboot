package com.goat.bean;

/**
 * Created by 64274 on 2018/8/24.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/24---3:07
 */
public class ResponseMessage {

    public ResponseMessage(String message) {
        this.message = message;
    }

    /**
     * 响应消息
     */

    private String message ;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}