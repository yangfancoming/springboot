package com.goat.model;

/**
 * Created by 64274 on 2019/3/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/7---20:59
 */
public class Wx {

    public Wx(String code, String pn, Long count) {
        this.code = code;
        this.pn = pn;
        this.count = count;
    }

    public Wx(String pn, Long count) {
        this.pn = pn;
        this.count = count;
    }

    String code;
    String pn;
    Long count;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
