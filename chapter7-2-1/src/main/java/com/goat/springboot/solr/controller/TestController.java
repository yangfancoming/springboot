package com.goat.springboot.solr.controller;

import com.goat.springboot.solr.model.User;
import com.goat.springboot.solr.service.ISolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.MapSolrParams;
import org.apache.solr.common.util.NamedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2019/7/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/22---10:24
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ISolrService solrService;

    @Autowired
    private SolrClient solrClient;

    //批量增加   http://localhost:8721/test/addUsers
    @RequestMapping("/addUsers")
    public void addUsers() throws IOException, SolrServerException {
        List<User> users = solrService.addUser();
        solrClient.addBeans(users);
        solrClient.commit();
    }

    //单个增加   http://localhost:8721/test/addUser
    @RequestMapping("/addUser")
    public void addUser() throws IOException, SolrServerException {
        User user = new User();
        user.setId("456788");
        user.setName("王强");
        user.setAddress("北京市");
        user.setSex("女");
        user.setHost(456752);
        solrClient.addBean(user);
        solrClient.commit();
    }

    //根据di查询   http://localhost:8721/test/getByIdFromSolr/456788
    @RequestMapping("/getByIdFromSolr/{id}")
    public String getByIdFromSolr(@PathVariable("id") String id) throws IOException, SolrServerException {

        //根据id查询内容
        SolrDocument solrDocument = solrClient.getById(id);
        if (solrDocument == null) {
            return "没查询到结果哦！";
        }
        //获取filedName
        Collection<String> fieldNames = solrDocument.getFieldNames();
        //获取file名和内容
        Map<String, Object> fieldValueMap = solrDocument.getFieldValueMap();
        System.out.println("byId=================="+solrDocument);
        System.out.println("fieldNames=================="+fieldNames);
        System.out.println("fieldValueMap=================="+fieldValueMap);
        return solrDocument.toString();
    }

    //根据di删除
    @RequestMapping("/delById/{id}")
    public  void  delById(@PathVariable("id") String id) throws IOException, SolrServerException {
        //根据id删除信息
        UpdateResponse updateResponse = solrClient.deleteById(id);
        //执行的时间
        long elapsedTime = updateResponse.getElapsedTime();
        int qTime = updateResponse.getQTime();
        //请求地址
        String requestUrl = updateResponse.getRequestUrl();
        //请求的结果{responseHeader={status=0,QTime=2}}
        NamedList<Object> response = updateResponse.getResponse();
        //请求结果的头{status=0,QTime=2}
        NamedList responseHeader = updateResponse.getResponseHeader();
        //请求的状态 0
        int status = updateResponse.getStatus();

        System.out.println("elapsedTime==========="+elapsedTime);
        System.out.println("qTime==========="+qTime);
        System.out.println("requestUrl==========="+requestUrl);
        System.out.println("response==========="+response);
        System.out.println("responseHeader==========="+responseHeader);
        System.out.println("status==========="+status);
    }
    //     http://localhost:8721/test/queryFromSolr1/
    @RequestMapping("/queryFromSolr1")
    public  Object  queryFromSolr1() throws IOException, SolrServerException {
        Map<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("q", "*:*");
        queryParamMap.put("f1","id,name");
        queryParamMap.put("sort","id asc");
        MapSolrParams mapSolrParams = new MapSolrParams(queryParamMap);
        QueryResponse results = solrClient.query(mapSolrParams);
        SolrDocumentList documentList = results.getResults();
        for (SolrDocument solrDocument : documentList) {
            System.out.println("solrDocument==============" +solrDocument);
        }
        return documentList;

    }

    //     http://localhost:8721/test/queryFromSolr2/
    @RequestMapping("/queryFromSolr2")
    public  Object  queryFromSolr2() throws IOException, SolrServerException {
        SolrQuery solrQuery  = new SolrQuery();
        solrQuery.setQuery("*:*");
        solrQuery.addField("*");
        solrQuery.add("q","id:4567");
        solrQuery.setSort("id", SolrQuery.ORDER.asc);
        solrQuery.setRows(50); //设置查询的条数
        solrQuery.setStart(0); //设置查询的开始
        solrQuery.setHighlight(true);  //设置高亮
        solrQuery.addHighlightField("item_name"); //设置高亮的字段
        solrQuery.setHighlightSimplePre("<font color='red'>"); //设置高亮的样式
        solrQuery.setHighlightSimplePost("</font>");
        System.out.println(solrQuery);
        QueryResponse response = solrClient.query(solrQuery);
        //返回高亮显示结果
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        System.out.println(highlighting);
        SolrDocumentList documentList = response.getResults();
        for (SolrDocument solrDocument : documentList) {
            System.out.println("solrDocument==============" +solrDocument);
        }
        return documentList;
    }

}
