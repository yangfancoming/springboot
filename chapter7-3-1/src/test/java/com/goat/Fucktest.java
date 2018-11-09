package com.goat;


import com.goat.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.cluster.NodesInfo;
import io.searchbox.core.Index;
import io.searchbox.indices.ClearCache;
import io.searchbox.indices.CloseIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


/**
     * @Description:
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/10/4



索引-数据库
类型-表
文档-表中的记录
属性-列


 SpringBoot 默认支持两种数来和ES进行交互
 1. Jest （默认不生效）  需要导入  io.searchbox.client.JestClient  在 JestAutoConfiguration 文件中 可以看到


 2. SpringData ElasticResearch  （默认生效）
    1.Client 节点信息 clusterNodes、clusterName
    2.ElasticResearchTemplate 操作ES
    3.编写一个 ElasticResearchRepository的子接口 来操作 ES
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Fucktest {

    @Autowired public JestClient jestClient;

    @Test
    public void create() throws IOException {
        Article article = new Article();
        article.setId(2);
        article.setTitle("山羊来了2222");
        //  构建一个索引功能 Index.Builder(要保存的数据).index(保存的位置).type(保存的类型)
        Index build = new Index.Builder(article).index("goat").type("news").build();
        JestResult result = jestClient.execute(build);
        System.out.println(result);
    }
    /**
     * 将删除 指定索引
     * @throws Exception
     */
    @Test
    public  void deleteIndex() throws Exception {
        DeleteIndex deleteIndex = new DeleteIndex.Builder("goat").build();
        JestResult result = jestClient.execute(deleteIndex);
        System.out.println(result.getJsonString());
    }
    /**
     * 关闭索引
     * @throws Exception
     */
    @Test
    public  void closeIndex() throws Exception {
        CloseIndex closeIndex = new CloseIndex.Builder("article").build();
        JestResult result = jestClient.execute(closeIndex);
        System.out.println(result.getJsonString());
    }
    /**
     * 判断索引目录是否存在  doit 这里为什么 给了正确的索引  却查不出来？
     * @throws Exception
     */
    @Test
    public  void indicesExists() throws Exception {
        IndicesExists indicesExists = new IndicesExists.Builder("article").build(); //null
//        IndicesExists indicesExists = new IndicesExists.Builder("goat").build();
        JestResult result = jestClient.execute(indicesExists);
        System.out.println(result.getJsonString());
    }

    /**
     * 查看节点信息
     * @throws Exception
     */
    @Test
    public  void nodesInfo() throws Exception {
        NodesInfo nodesInfo = new NodesInfo.Builder().build();
        JestResult result = jestClient.execute(nodesInfo);
        System.out.println(result.getJsonString());
    }

    /**
     * 清缓存
     * @throws Exception
     */
    @Test
    public  void clearCache() throws Exception {
        ClearCache closeIndex = new ClearCache.Builder().build();
        JestResult result = jestClient.execute(closeIndex);
        System.out.println(result.getJsonString());
    }


}
