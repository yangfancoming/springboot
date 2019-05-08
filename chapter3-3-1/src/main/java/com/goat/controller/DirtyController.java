package com.goat.controller;

import com.goat.service.DirtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("dirty")
public class DirtyController {

    @Autowired
    DirtyServiceImpl dirtyService;

    //    http://localhost:8331/dirty/test2
    @GetMapping("test2")
    public void test2() throws InterruptedException {
        dirtyService.select();
    }

    //    http://localhost:8331/dirty/test22
    @GetMapping("test22")
    public void test22() throws InterruptedException {
        dirtyService.insert();
    }
}
