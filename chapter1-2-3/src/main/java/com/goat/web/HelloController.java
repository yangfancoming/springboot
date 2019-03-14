package com.goat.web;

import com.goat.model.Foo;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    //   http://localhost:8123/hello?name=goat
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    //   http://localhost:8123/hello2
    @GetMapping("/hello2")
    public Foo hello2() {
        Foo foo = new Foo("123",11);
        return foo;
    }


}
