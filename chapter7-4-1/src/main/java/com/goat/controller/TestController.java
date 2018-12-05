package com.goat.controller;


import com.goat.bean.Article;
import com.goat.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BookRepository bookRepository;

    //http://localhost:8741/test/save
    @GetMapping("save")
    public String save(){
        Article article = new Article();
        article.setId(111);
        article.setTitle("山羊来了111");
        Article temp =  bookRepository.save(article);
        System.out.println(temp);
        return "success";
    }
    //http://localhost:8741/test/delete?id=1525415333329
    @GetMapping("delete")
    public String delete(Integer id){
        bookRepository.deleteById(id);
        return "success";
    }

    //http://localhost:8741/test/update?id=1525417362754&name=修改&description=修改
    @GetMapping("update")
    public String update(Integer id,String title){
        Article goodsInfo = new Article(id, title);
        bookRepository.save(goodsInfo);
        return "success";
    }

    //http://localhost:8741/test/getOne?id=1525417362754
    @GetMapping("getOne")
    public Optional<Article> getOne(Integer id){
        return bookRepository.findById(id);
    }

}
