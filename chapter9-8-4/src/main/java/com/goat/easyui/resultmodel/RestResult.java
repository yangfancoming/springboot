package com.goat.easyui.resultmodel;

/**
 * 统一封装API返回信息
 * 千万别加@Entity 否则Hibernate会给你创建表
 */
public class RestResult {

    private int code;  //状态码
    private long count;  // 总记录数
    private String msg; //消息
    private Object data; //额外的内容

    public RestResult(){ }

    public RestResult setCode(ResultCode code) {
        this.code = code.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public RestResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return msg;
    }

    public RestResult setMessage(String message) {
        this.msg = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RestResult setData(Object data) {
        this.data = data;
        return this;
    }

    public long getTotal()
    {
        return count;
    }

    public RestResult setTotal(long total)
    {
        this.count = total;
        return this;
    }
}
