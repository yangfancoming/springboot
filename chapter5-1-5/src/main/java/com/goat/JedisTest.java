package com.goat;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by 64274 on 2018/8/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/23---22:18
 */
public class JedisTest {

    Jedis jedis;

    @BeforeMethod
    public void test(){
         jedis = new Jedis("172.16.163.135",6379); // 连接 redis 服务器
    }

    @Test
    public void ping(){
        System.out.println(jedis.ping()); // 测试服务器连接
    }

    @Test
    public void test1(){
        /*
            * 其中 "return {KEYS[1],KEYS[2],ARGV[1],ARGV[2]}" 是被求值的 Lua 脚本，数字 2 指定了键名参数的数量，
            * key1 和 key2 是键名参数，分别使用 KEYS[1] 和 KEYS[2] 访问，而最后的 first 和 second 则是附加参数，可以通过 ARGV[1] 和 ARGV[2] 访问它们。
            *
            * 注意，这里一些操作不适用于redis-cluster，主要还是因为不同的key被分配到了不同的slot中
        */
        Object eval = jedis.eval("return {KEYS[1],ARGV[1],ARGV[2]}", 1, "lua", "key1", "dd");
        System.out.println(eval);

    }
    @Test
    public void test3(){
        //脚本里使用的所有键都应该由 KEYS 数组来传递：
        //因为：所有的 Redis 命令，在执行之前都会被分析，籍此来确定命令会对哪些键进行操作。因此，对于 EVAL 命令来说，必须使用正确的形式来传递键，才能确保分析工作正确地执行
        System.out.println(jedis.eval("return redis.call('set', KEYS[1], ARGV[1])", 1, "luaTest", "cv"));
        System.out.println(jedis.get("luaTest"));
    }
    @Test
    public void test4(){
        //注意这里需要指定KEY，因为这里lua脚本也是和slot挂钩的
        String scriptLoad = jedis.scriptLoad("return redis.call('get', KEYS[1])");//加载脚本
        System.out.println(scriptLoad);//返回的SHA1校验和，后续可以直接使用这个进行操作。
        System.out.println(jedis.scriptExists(scriptLoad, "luaTest"));//检查是否存在

        System.out.println(jedis.evalsha(scriptLoad, 1, "luaTest"));//执行lua脚本
        System.out.println(jedis.scriptFlush());//删除KEY as  上的所有lua脚本
        System.out.println(jedis.scriptExists(scriptLoad, "luaTest"));
        System.out.println(jedis.evalsha(scriptLoad, 1, "luaTest"));//脚本已经删除，返回错误：NOSCRIPT No matching script. Please use EVAL.
    }


    /**
     * redis中的lua脚本做了很多限制，防止随机性的发生。比如lua脚本中返回的总是有序的集合。
     * 详情见 http://doc.redisfans.com/script/eval.html - 纯函数脚本
     */
    @Test
    public void scriptFuc() throws InterruptedException {
        String key = "luaTest";
        System.out.println(jedis.del(key));
        System.out.println(jedis.sadd(key, "10","3","7","40","6"));
        System.out.println(jedis.smembers(key));//这里怎么返回的值是有序的？  [3, 6, 7, 10, 40]
        System.out.println(jedis.eval("return redis.call('smembers', KEYS[1])", 1, key));//根据字母序排序  [10, 3, 40, 6, 7]
    }

}
