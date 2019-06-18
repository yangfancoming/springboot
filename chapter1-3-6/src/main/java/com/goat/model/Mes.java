package com.goat.model;


/**
 * Created by 64274 on 2019/6/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/18---15:33
 */
public class Mes {

    Boolean success;
    String msg;
    Object attributes;
//    List<Temp> obj;
    Temp[] obj;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getAttributes() {
        return attributes;
    }

    public void setAttributes(Object attributes) {
        this.attributes = attributes;
    }

//    public List<Temp> getTemps() {
//        return obj;
//    }
//
//    public void setTemps(List<Temp> temps) {
//        this.obj = temps;
//    }

    public Temp[] getObj() {
        return obj;
    }

    public void setObj(Temp[] obj) {
        this.obj = obj;
    }
}
