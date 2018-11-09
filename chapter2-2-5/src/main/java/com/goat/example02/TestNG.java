package com.goat.example02;


import com.google.gson.Gson;
import org.testng.annotations.Test;


public class TestNG {

    Gson gson = new Gson();

    //    json中嵌套json
    @Test
    public void test() {
        String str = "{\"name\":\"mrxi\",\"age\":\"24\",\"gender\":1,\"school\":\"bupt\",\"grade\":{\"course\":\"English\",\"score\":100,\"level\":\"A\"}}";
        Student student = gson.fromJson(str,Student.class);
        System.out.println(student);
    }




}
