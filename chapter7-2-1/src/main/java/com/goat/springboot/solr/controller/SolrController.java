package com.goat.springboot.solr.controller;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 64274 on 2019/7/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/18---15:31
 */

@RestController
@RequestMapping("/solr")
public class SolrController {

    @Autowired
    private SolrClient client;

    private static final String collection = "mycore";

    /**    http://localhost:8721/solr/add
     * 新增/修改 索引
     * 当 id 存在的时候, 此方法是修改(当然, 我这里用的 uuid, 不会存在的), 如果 id 不存在, 则是新增
     */
    @RequestMapping("/add")
    public String add() throws IOException, SolrServerException {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id", "1");
        doc.setField("user_name", "山羊来了");
        doc.setField("user_address", "我是中国人, 我爱中国");
        client.add(collection, doc);
        client.commit(collection);

        doc.setField("id", "2");
        doc.setField("user_name", "马云");
        doc.setField("user_address", "我是中国人, 我也爱中国");
        client.add(collection, doc);
        client.commit(collection);
        return uuid;
    }

    /**   http://localhost:8721/solr/getById?id=2
     * 根据id查询索引
     */
    @RequestMapping("/getById")
    public String getById(String id) throws Exception {
        SolrDocument document = client.getById(collection, id);
        System.out.println(document);
        return document.toString();
    }

    /**  http://localhost:8721/solr/delete?id=2
     * 根据id删除索引
     */
    @RequestMapping("/delete")
    public String delete(String id) throws IOException, SolrServerException {
        client.deleteById(collection,id);
        client.commit(collection);
        return id;
    }


    /**   http://localhost:8721/solr/deleteAll
     * 删除所有的索引
     */
    @RequestMapping("/deleteAll")
    public String deleteAll() throws IOException, SolrServerException {
        client.deleteByQuery(collection,"*:*");
        client.commit(collection);
        return "success";
    }




    /**   http://localhost:8721/solr/search doit 报错 是不是因为 没有设置 Collection 的原因？
     * 综合查询: 在综合查询中, 有按条件查询, 条件过滤, 排序, 分页, 高亮显示, 获取部分域信息
     */
    @RequestMapping("/search")
    public Map<String, Map<String, List<String>>> search() throws IOException, SolrServerException {

        SolrQuery params = new SolrQuery();

        //            params.set("q", "马");  //查询条件, 这里的 q 对应 下面图片标红的地方
        // params.set("fq", "product_price:[100 TO 100000]");   //过滤条件
        // params.addSort("product_price", SolrQuery.ORDER.asc);   //排序

        //分页
        params.setStart(0);
        params.setRows(20);
        //            params.set("df", "user_name");  //默认域
        //            params.set("fl", "id,user_name,user_address");  //只查询指定域

        params.setHighlight(true);   //高亮 开关
        params.addHighlightField("user_name");   //指定高亮域
        params.setHighlightSimplePre("<span style='color:red'>");  //设置前缀
        params.setHighlightSimplePost("</span>");  //设置后缀

        QueryResponse queryResponse = client.query(params);
        SolrDocumentList results = queryResponse.getResults();
        long numFound = results.getNumFound();
        System.out.println(numFound);

        //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
        Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();

        for (SolrDocument result : results) {
            System.out.println(result.get("id"));
            System.out.println(result.get("user_name"));
            System.out.println(result.get("user_address"));

            Map<String, List<String>> map = highlight.get(result.get("id"));
            List<String> list = map.get("user_name");
            System.out.println(list.get(0));

            System.out.println("------------------");
        }
        return highlight;
    }
}
