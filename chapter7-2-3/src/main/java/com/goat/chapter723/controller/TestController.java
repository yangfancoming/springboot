package com.goat.chapter723.controller;


import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;


@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private SolrClient solrClient;

    private static final String SOLR_COLLECTION_USER = "user";

    // http://localhost:8723/test/test1
    @GetMapping("/test1")
    public UpdateResponse test1() throws Exception {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", 1001L);
        document.addField("username", "test");
        document.addField("password", "123123");
        document.addField("remark", "solr index test");
        document.addField("createDate", new Date());
        solrClient.add(SOLR_COLLECTION_USER, document);
        UpdateResponse commit = solrClient.commit(SOLR_COLLECTION_USER);
        return commit;
    }



}
