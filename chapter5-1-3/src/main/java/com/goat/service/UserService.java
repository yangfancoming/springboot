package com.goat.service;

import com.goat.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by 64274 on 2018/11/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/14---9:58
 *
 * 使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”
 * @CacheConfig: 类级别的注解：如果我们在此类中定义 cacheNames，则此类中的所有方法上 @Cacheable 的cacheNames默认都是此值。当然@Cacheable也可以覆盖定义cacheNames的值
 */

@Service
@CacheConfig(cacheNames="booksAll")
public class UserService {

    // @Cacheable缓存key为name的数据到缓存usercache中
    @Cacheable(value = "usercache", key = "#name")
    public User findUser(String name) {
        System.out.println("无缓存1.............." );
        return new User(1, name);
    }

    @Cacheable(value = "usercache2", key = "#p0")
    public User findUser2(String name) {
        System.out.println("无缓存2.............." );
        return new User(1, name);
    }

    /***
     *  如果设置sync=true，
     *  如果缓存中没有数据，多个线程同时访问这个方法，则只有一个方法会执行到方法，其它方法需要等待
     *  如果缓存中已经有数据，则多个线程可以同时从缓存中获取数据
     * @param name
     * @return
     */
    @Cacheable(value = "usercache3", sync=true)
    public User findUser3(String name) {
        System.out.println("无缓存3.............." );
        return new User(1, name);
    }


    // @CacheEvict从缓存usercache中删除key为name的数据
    @CacheEvict(value = "usercache", key = "#p0")
    public void removeUser(String name) {
        System.out.println("删除数据" + name + "，同时清除对应的缓存");
    }

    // allEntries = true: 清空 usercache 里的所有缓存
    @CacheEvict(cacheNames="usercache", allEntries=true)
    public void clearAll(){
        System.out.println("清空usercache 中的所有缓存数据哦");
    }

    /**
     * 每次执行都会执行方法，无论缓存里是否有值，同时使用新的返回值的替换缓存中的值
     * 	这里不同于@Cacheable：@Cacheable如果缓存没有值，从则执行方法并缓存数据，如果缓存有值，则从缓存中获取值
     * 	@CachePut缓存新增的数据到缓存usercache中
     */
    @CachePut(value = "usercache", key = "#p0")
    public User save(int age,String name) {
        System.out.println("添加lisi用户");
        return new User(age, name);
    }

    /**
         condition和unless 只满足特定条件才进行缓存：
         condition ： 在执行方法前，condition的值为true，则缓存数据
         unless ：在执行方法后，判断unless ，如果值为true，则不缓存数据
         conditon和unless可以同时使用，则此时只缓存同时满足两者的记录
     * 条件缓存：
     * 只有满足condition的请求才可以进行缓存，如果不满足条件，则跟方法没有@Cacheable注解的方法一样
     * 	如下面只有id < 3才进行缓存
     */
    @Cacheable(cacheNames="MyUser", condition="T(java.lang.Integer).parseInt(#id) < 33 ")
    public User condition(String id) {
        System.out.println("无缓存。。。。。。。。。。。。。。");
        return new User(id, "temp");
    }

    /**
     * 条件缓存：
     * 对不满足unless的记录，才进行缓存
     */
    @Cacheable(cacheNames="MyUser", unless="T(java.lang.Integer).parseInt(#id) < 33 ")
    public User unless(String id) {
        System.out.println("无缓存。。。。。。。。。。。。。。");
        return new User(id, "temp");
    }


    // cacheNames默认都是此值 booksAll  key 默认值是 参数名 wahaha  redis中的保存结果： booksAll::321
    @Cacheable
    public User booksAll(String wahaha) {
        System.out.println("无缓存。。。。。。。。。。。。。。");
        return new User(wahaha, "temp");
    }
}
