package com.goat.controller;


import com.goat.entity.Article;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired private JestClient jestClient;

    /**
     *     http://localhost:8731/hello/create   创建索引
     *     http://172.16.163.135:9200/goat/news/1   查询已经操作的索引
     构建一个索引功能 Index.Builder(要保存的数据).index(保存的位置).type(保存的类型)
     保存成功后 查询url ：http://192.168.235.207:9200/goat/news/1
    */
    @RequestMapping("/create")
    public void create() throws IOException {
        Article article = new Article();
        article.setId(1);
        article.setTitle("山羊来了");
        //Index build = new Index.Builder(article).index("goat").type("").build(); // 不指定类型 会报错：java.io.IOException: Request PUT http://192.168.235.207:9200/goat/1 HTTP/1.1 yielded text/plain; charset=UTF-8, should be json: HTTP/1.1 400 Bad Request
        Index build = new Index.Builder(article).index("goat").type("news").build();
        JestResult result = jestClient.execute(build);
        System.out.println(result);
    }

    /**
      测试url ： http://localhost:8731/hello/create2
      保存成功后 查询url ：http://192.168.235.207:9200/goat/news/123
    */
    @RequestMapping("/create2")
    public void create2() throws IOException {
        String json = "{\"id\":\"123\",\"title\":\"山羊来了\"}";
        Index build = new Index.Builder(json).index("goat").type("news").build();
        JestResult result = jestClient.execute(build);
        System.out.println(result);
    }

    /**
     * http://localhost:8731/hello/search   搜索
     new Search.Builder(要搜索的json表达式).addIndex(指定在哪个索引下搜索).addType(指定在哪个类型下搜索)
     */
    @RequestMapping("/search")
    public void search() throws IOException {
        // 搜索 title内容 为山羊的 数据
        String json = "{\"query\" : {\"match\" : {\"title\" : \"山羊\"}}}";
        Search build = new Search.Builder(json).addIndex("goat").addType("news").build();
        SearchResult execute = jestClient.execute(build);
        System.out.println(execute.getJsonString());
    }
}
