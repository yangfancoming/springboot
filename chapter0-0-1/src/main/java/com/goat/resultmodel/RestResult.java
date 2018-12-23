package com.goat.resultmodel;

/**
 * 统一封装API返回信息
 * 千万别加@Entity 否则Hibernate会给你创建表
 * Created by bekey on 2017/12/10.
 */
public class RestResult {

    private Integer code;  //状态码
    private Boolean flag; // 标记
    private String message; //消息
    private Object data; //额外的内容

    public RestResult(){ }

    public RestResult setCode(ResultCode code) {
        this.code = code.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RestResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }


}
