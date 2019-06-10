package com.goat;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
     * @Description:
     * @author: Goat
     * @Date:   2018/10/5

• 数据库（database）库    – 数据库是一个仓库，在仓库中可以存放集合。
• 集合（collection）表    – 集合类似于数组，在集合中可以存放文档。
• 文档（document）  记录  – 文档数据库中的最小单位，我们存储和操作的内容都是文档。

*/


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Autowired public MongoTemplate mongoTemplate;
//    public final Logger log = LoggerFactory.getLogger(this.getClass());
}

