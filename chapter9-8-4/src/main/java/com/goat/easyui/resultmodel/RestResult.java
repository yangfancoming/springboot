package com.goat.easyui.resultmodel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 统一封装API返回信息
 * 千万别加@Entity 否则Hibernate会给你创建表
 */
public class RestResult<T> {

    private int code;  //状态码
    @JsonProperty("total")
    private long count;  // 总记录数
    private String msg; //消息
    private Object data; //额外的内容

    private Iterable<T> rows;

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

    public long getTotal(){

        return count;
    }

    public RestResult setTotal(long total){

        this.count = total;
        return this;
    }

    public Iterable<T> getRows() {
        return rows;
    }

    public RestResult setRows(Iterable<T> rows) {
        this.rows = rows;
        return this;
    }
}
