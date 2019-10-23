package com.goat.chapter118.model;


public class Address {

    private String code;
    private String location;

    public Address(String code, String location) {
        this.code = code;
        this.location = location;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
