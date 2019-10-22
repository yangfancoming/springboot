package com.goat.others;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.*;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.addEachToSet;

/**
 * 原生java驱动Document的操作测
 */
public class MongoTemplateTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private MongoDatabase db;
	private MongoCollection<Document> doc;
	private MongoClient client;

	@Before
	public void init() {
		client = new MongoClient("192.168.136.128", 27017);
		db = client.getDatabase("test");
		doc = db.getCollection("persons");
	}

	/**
	 * 测试插入数据
	 */
	@Test
	public void testInsert() {
		Document doc1 = new Document();
		doc1.append("username", "tom");
		doc1.append("contry", "Englan");
		doc1.append("age", 18);
		doc1.append("lenght", 1.77f);
        // fuck  BigDecimal 该类型 需要在 mongodb 3.4版本以上 才能使用 否则报错：com.mongodb.MongoSocketReadException: Prematurely reached end of stream
		doc1.append("salary", new BigDecimal("6585.23"));
		Map<String, String> address1 = new HashMap<>();
		address1.put("aCode", "0000");
		address1.put("add", "xxx000");
		doc1.append("address", address1);
		Map<String, Object> favorites1 = new HashMap<>();
		favorites1.put("movies", Arrays.asList("aa", "bb"));
		favorites1.put("cities", Arrays.asList("广州", "深圳"));
		doc1.append("favorites", favorites1);

		Document doc2 = new Document();
		doc2.append("username", "tony");
		doc2.append("contry", "USA");
		doc2.append("age", 28);
		doc2.append("lenght", 1.77f);
		Map<String, String> address2 = new HashMap<>();
		address2.put("aCode", "0000");
		address2.put("add", "xxx000");
		doc2.append("address", address2);
		Map<String, Object> favorites2 = new HashMap<>();
		favorites2.put("movies", Arrays.asList("cc", "dd"));
		favorites2.put("cities", Arrays.asList("南宁", "衡阳"));
		doc2.append("favorites", favorites2);
		doc.insertMany(Arrays.asList(doc1, doc2));
	}

    @Test
    public void testGetAllTables() { // 获取 指定数据库 中  所有集合名称
        MongoIterable<String> tables = db.listCollectionNames();
        for (String coll : tables) {
            System.out.println(coll);
        }
    }

    @Test
    public void testSave() {
        MongoCollection<Document> table  = db.getCollection("persons");
        Document document = new Document();
        document.put("name", "小郭");// 能直接插入汉字
        document.put("age", 24);
        table.insertOne(document);
    }

    @Test
    public void testSave3(){
        MongoCollection<Document> table = db.getCollection("persons");
        Map<String,Object> maps = new HashMap<>();
        maps.put("name", "小李");
        maps.put("password", "xiaozhang");
        maps.put("age", 24);
        Document document = new Document(maps);//这样添加后，对象里的字段是无序的。
        table.insertOne(document);
    }
    //db.users.remove({name:"posly"})
    @Test
    public void testDelete1(){
        MongoCollection<Document> table = db.getCollection("persons");
        Document query = new Document("name", "小李");
        DeleteResult deleteResult = table.deleteOne(query);
        log.info("删除的行数为：{}", deleteResult.getDeletedCount());
    }



	/**
	 * 删除测试
	 */
	@Test
	public void testDelete() {
		// delete from users where username = 'iuv'
		DeleteResult deleteMany = doc.deleteMany(Filters.eq("username", "iuv"));
		log.info("删除的行数为：{}", deleteMany.getDeletedCount());

		// delete from users where age >8 and age <25
		DeleteResult deleteMany2 = doc.deleteMany(and(gt("age", 8), lt("age", 25)));
		log.info("删除的行数为：{}", deleteMany2.getDeletedCount());
	}

	/**
	 * 更新测试
	 */
	@Test
	public void testUpdate() {
		// update users set age = 6 where username = 'tom'
		UpdateResult updateNum = doc.updateMany(eq("username", "tom"), new Document("$set", new Document("age", 6)));
		log.info("更新的行数为：{}", updateNum.getModifiedCount());

		// update users set favorites.movies add "蜘蛛侠","钢铁侠" where
		// favorites.cities has "深圳"
		UpdateResult updateNum2 = doc.updateMany(eq("favorites.cities", "深圳"),
				addEachToSet("favorites.movies", Arrays.asList("蜘蛛侠", "钢铁侠")));
		log.info("更新的行数为：{}", updateNum2.getModifiedCount());
	}

	/**
	 * 查询测试
	 */
    final List<Document> ret = new ArrayList<>();
    Block<Document> printBlock = t->{
        log.info("{}", t.toJson());
        ret.add(t);
    };

	@Test
    public void testFind1() {
        // select * from users where favorites.cities has "深圳"、"广州"
        FindIterable<Document> find = doc.find(all("favorites.cities", Arrays.asList("深圳", "广州")));
        find.forEach(printBlock);
        log.info(String.valueOf(ret.size()));
        ret.removeAll(ret);// 将集合清空

    }
    @Test
    public void testFind2() {
        // select * from users where username like '%om%' and (contry=Englan or contry=USA)
        String regexStr = ".*om.*";
        Bson regex = regex("username", regexStr);
        Bson or = or(eq("contry", "Englan"), eq("contry", "USA"));
        FindIterable<Document> find2 = doc.find(and(regex, or));
        find2.forEach(printBlock);
        log.info(String.valueOf(ret.size()));
    }
}
