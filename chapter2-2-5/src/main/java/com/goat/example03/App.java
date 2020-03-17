package com.goat.example03;


import com.goat.BaseTest;
import org.junit.Test;


public class App extends BaseTest {

    // json 中包含 jsonArray
    @Test
    public void test1() {
        String str = "{\"name\":\"mrxi\",\"age\":\"24\",\"gender\":1,\"school\":\"bupt\",\"grade\":[{\"course\":\"English\",\"score\":100,\"level\":\"A\"},{\"course\":\"Math\",\"score\":90,\"level\":\"A\"}]}";
        Student student = gson.fromJson(str,Student.class);
        System.out.println(student);
    }
}
