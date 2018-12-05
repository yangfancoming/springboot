package com.goat.example03;


import com.google.gson.Gson;
import org.testng.annotations.Test;


public class TestNG {

    private final Gson gson = new Gson();

    //    json 中包含 jsonArray
    @Test
    public void test1() {
        String str = "{\"name\":\"mrxi\",\"age\":\"24\",\"gender\":1,\"school\":\"bupt\",\"grade\":[{\"course\":\"English\",\"score\":100,\"level\":\"A\"},{\"course\":\"Math\",\"score\":90,\"level\":\"A\"}]}";
        Student student = gson.fromJson(str,Student.class);
        System.out.println(student);
    }
}
