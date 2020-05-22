package com.goat.fastjson.demo;

/**
 * Created by Administrator on 2020/5/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/5/22---11:24
 */
public class Request {

    String url;

    QueryString queryString;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public QueryString getQueryString() {
        return queryString;
    }

    public void setQueryString(QueryString queryString) {
        this.queryString = queryString;
    }
}
