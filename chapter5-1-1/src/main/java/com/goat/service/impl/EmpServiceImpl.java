package com.goat.service.impl;

import com.goat.bean.Emp;
import com.goat.dao.BaseDao;
import com.goat.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/8/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/20---17:48
 */
@Service
public class EmpServiceImpl implements IEmpService {

    @Autowired BaseDao baseDao;

    @Resource
    RedisTemplate<String,Object> redisTemplate;


/**
     * @author: 杨帆
        该方法存在  缓存穿透 问题：在高并发条件下，有一万人同时请求该方法，同时进入if(map==null)内，
        那么就会查询一万次数据库 而我们想要的是 只要第一个人的请求 查询数据库后 就进行缓存其余的9999人走缓存
        解决方法： 在函数声明中 加上 synchronized 锁
     * @Date:   2018/8/22
*/
    @Override
    public synchronized Map findById(String id) {
        Map map = (Map) redisTemplate.opsForValue().get("findById");
        if(map==null){
            map = baseDao.findById(id); // 查询单条记录
            System.out.println("查询数据库了哦");
            redisTemplate.opsForValue().set("findById",map);
        }else {
            System.out.println("走了。。。。redisTemplate 缓存");
        }
        return map;
    }

    @Override
    public List<Emp> findAll() {
        List<Emp> maps = (List<Emp>) redisTemplate.opsForValue().get("findAll");
        if(maps==null){
            maps = baseDao.findAll();  // 查询全部记录
            System.out.println("查询数据库了哦");
            redisTemplate.opsForValue().set("findAll",maps);
        }else {
            System.out.println("走了。。。。redisTemplate 缓存");
        }
        return maps;
    }
}
