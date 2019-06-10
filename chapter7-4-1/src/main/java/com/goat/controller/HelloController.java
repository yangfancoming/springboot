package com.goat.controller;


import com.goat.entity.Article;

import com.goat.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired private BookRepository bookRepository;


    // doit 访问这里 就是报错 None of the configured nodes are available: [{#transport#-1}{MoE3kZeuQV2rPw5xzPPHXw}{172.16.163.135}{172.16.163.135:9200}]
//    http://localhost:8741/hello/create   创建索引
//    http://172.16.163.135:9300/goat/news/1   查询已经操作的索引
    @RequestMapping("/create")
    public void create() {
        Article article = new Article();
        article.setId(1);
        article.setTitle("山羊来了");
        /**
         构建一个索引功能
         Index.Builder(要保存的数据).index(保存的位置).type(保存的类型)
         */
        bookRepository.index(article);
//        Index build = new Index.Builder(article).index("goat").type("news").build();
//        jestClient.execute(build);
        System.out.println("数据索引成功！");
    }

/**
     * @Description:
     * @author: Goat
        new Search.Builder(要搜索的json表达式).addIndex(指定在哪个索引下搜索).addType(指定在哪个类型下搜索)
     * @Date:   2018/8/22
*/

    @RequestMapping("/search")
    public void search()  {
        // 搜索 title内容 为山羊的 数据
//        String json = "{\n" + "\"query\" : {\n" + "\"match\" : {\n" + "\"title\" : \"山羊\"\n" + "}\n" + "}\n" + "}";
//        Search build = new Search.Builder(json).addIndex("goat").addType("news").build();
//        SearchResult execute = jestClient.execute(build);
//        System.out.println(execute.getJsonString());
    }
}
