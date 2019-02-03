package com.goat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    // http://localhost:8353/article/list
    @GetMapping("/list")
    public ResponseEntity<List<String>> list(){
        System.out.println("haha");
        return null;
    }

    // http://localhost:8353/1
    @GetMapping("/{id}")
    public ResponseEntity<String> read(@PathVariable Long id){
        return null;
    }


}
