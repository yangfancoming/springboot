package com.goat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpsForValue extends RedisCommon {


    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> redisOperations;

    //这里注入的 stringOperations 免去了 stringOperations
    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, Object> stringOperations;
    /**
         * @Description:  stringRedisTemplate 操作 字符串 总结
         * @author: 杨帆
         * @Date:   2018/10/7
     *
    RedisTemplate 使用的是 JdkSerializationRedisSerializer 用于 字符串类型操作
    StringRedisTemplate 使用的是 StringRedisSerializer  用于复杂类型 操作

     这里的 test1() 和 test2() 插入了不同的值  我的理解是：
    redisTemplate 使用了 json序列化  插入的实际上是 json 数据
    stringRedisTemplate 只是操作字符串  插入就是字符串
    */

    /**
         * @Description:  对应命令
         * @author: 杨帆
         * @Param:   set goat2 hahaha
         * @Return:  get goat2
         * @Date:   2018/10/7
    */
    @Test
    public void test1(){
        stringOperations.set("fuck1","tom"); // 这里插入的是 tom
        Assert.assertEquals("tom", stringOperations.get("fuck")); // OK
    }

    @Test
    public void test2(){
        redisOperations.set("fuck","tom"); // 这里插入的是 "tom"
        Assert.assertEquals("tom", stringOperations.get("fuck")); // 报错 did not expect to find ["tom"] but found [tom]
    }

    @Test
    public void set(){ // SET key value
        stringOperations.set("mark","aaa"); //  ****Template 方法的 set和get方法并没有提供返回值  但是在 jedis 中却有。。。
    }
    @Test
    public void get(){ // GET key
        String temp = (String) stringOperations.get("mark");
        System.out.println(temp); // 如果不存在 key  则返回 null
    }
    /**
     * @Description:  截取字符串，从开始下标位置开始到结束下标的位置(包含结束下标)的字符串
     * @author: 杨帆
     * @Param:    GETRANGE goat 1 3
     * @Return:  123456 ---> 234
     * @Date:   2018/10/7
     */
    @Test
    public void getrange(){
        String cutString = stringOperations.get("multi1",1,3);
        System.out.println("通过get(K key, long start, long end)方法获取截取的字符串:"+cutString);
    }
    /**
     * @Description:  获取原来的值并重新赋新值
     * @author: 杨帆
     * @Param:   GETSET key value
     * @Return:  返回旧值
     * @Date:   2018/10/7
     */
    @Test
    public void getAndSet(){  //
        Object temp = stringOperations.getAndSet("stringValue","ccc");
        System.out.print("temp:" + temp );
        Object value = stringOperations.get("stringValue");
        System.out.println("value:"+ value);
    }

    // getBit() 和 setBit() 由于二进制只有0和1,此处value只能取0和1,如图,其他值是超出范围的
    @Test
    public void getBit(){
        //判断指定的位置ASCII码的bit位是否为1   GETBIT key offset
        boolean bitBoolean = stringOperations.getBit("stringValue",1);
        System.out.println(bitBoolean);
    }

    @Test
    public void setBit(){ //key键对应的值value对应的ascii码,在offset的位置(从左向右数)变为value   SETBIT key offset value
        Boolean mark = stringOperations.setBit("stringValue",1,false);
        System.out.println(mark);
        Object temp = stringOperations.get("stringValue");
        System.out.println(temp);
    }

    /**
     * @Description:  设置变量值的过期时间
     * @Param:   SETEX key seconds value
     * @Date:   2018年10月8日21:03:33
     */
    @Test
    public void timeOut() throws InterruptedException {
        stringOperations.set("timeOutValue","timeOut",5, TimeUnit.SECONDS);
        System.out.println(stringOperations.get("timeOutValue")); // timeOut
        Thread.sleep(6*1000);
        System.out.println("等待5s过后，获取的值:" + stringOperations.get("timeOutValue")); // null
    }

    /**
     * @Description:  如果值不存在则新增,存在则不改变已经有的值
     * @Param:   SETNX key value
     * @Return:  存在返回true  否则返回false
     * @Date:   2018年10月8日21:14:36
     */
    @Test
    public void setIfAbsent() {
        boolean mark = stringOperations.setIfAbsent("absentValue","fff");
        System.out.println(mark);
    }

    /**
     * @Description:  在指定偏移处开始处覆盖value
     * @Param:   SETRANGE key offset value
     * @Return:  原来的值 fff  ---->  ffaaa
     * @Date:   2018年10月8日21:14:36
     */
    @Test
    public void setOverride()  {
        stringOperations.set("absentValue","aaa",2);
    }

    @Test
    public void size(){
        //获取指定key的 value 的长度   STRLEN key
        Long temp = stringOperations.size("fuck");
        System.out.println(temp);
    }
    /**
     15	INCR key	将键的整数值增加1
     16	INCRBY key increment	将键的整数值按给定的数值增加
     17	INCRBYFLOAT key increment	将键的浮点值按给定的数值增加
     18	DECR key	将键的整数值减1
     19	DECRBY key decrement	按给定数值减少键的整数值

     * @Description:  incr decr 操作 不存在的key时  则新建key 其value设置0  然后在进行 增加或减少操作  value 必须为整数型
     * @author: 杨帆
     * @Param:  delta 步长  （要变化的值） 负数===DECR 类指令   整数===INCR 类指令
     * @Return:
     * @Date:   2018/10/7
     */

    @Test
    public void incr(){
        Long temp = stringOperations.increment("test",3);
        System.out.println(temp);
    }
    @Test
    public void decr(){
        Long temp = stringOperations.increment("test",-4);
        System.out.println(temp);
    }
    /**

     * @Description:  如果key存在则 将value追加到旧value末尾，如果key不存在则 新增键值对
     * @author: 杨帆
     * @Param:   append goat 123
     * @Return:  返回 追加后 value 的总长度
     * @Date:   2018/10/7
     */
    @Test
    public void append(){
        Integer temp = stringOperations.append("name","aaa");
        System.out.println(temp);
    }

    /**
         * @Description:  根据key 删除 键值对
         * @Param:  del key
         * @Return: 返回 是否删除成功
         * @Date:   2018/10/7
    */
    @Test
    public void delete(){
        Boolean mark = stringRedisTemplate.delete("name");
        System.out.println(mark);
    }



}

