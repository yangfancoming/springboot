package com.goat.service;

import com.goat.dao.BaseDaoRepository;
import com.goat.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 服务类（加入缓存管理）建议只对单对象进行缓存，集合对象避免使用缓存
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private BaseDaoRepository baseDao;

    /**
     * Cacheable 每次查询，将查询结果放入缓存中
     *           相同id，第二次查询时只从缓存中取数据，提高数据查询效率
     *           key = "#id" : 表示在redis中k-v(key:id,value:PageDemoDto)
     */
    @Override
    @Cacheable(value = "pageCache",key = "#id")
    public User findById(Long id) {
        System.out.println("查询数据库了哦！");
        return baseDao.findById(id).get();
    }

    /**
     * List<?> 对象不建议纳入缓存管理，
     *         数据精确度降低缓存刷新难度大
     *         key利用配置的生成器来生成
     * @return
     */
    @Override
    @Cacheable(value = "pageCache",keyGenerator = "myKeyGenerator")
    public List<User> findAll() {
        return baseDao.findAll();
    }


    /**
     * CachePut 每次都触发真实的方法调用，将执行结果放入缓存中update 和 insert 实现方式一样
     *  插入（或更新）关系数据库后，重新按id查询出来，放入缓存中
     * @return
     */
    @Override
    @CachePut(value = "pageCache",key = "#user.id")
    @Transactional
    public User insertData(User user) {
        User result = baseDao.save(user);
        return result;
    }


    /**
     * CacheEvict 删除的数据，要将缓存中的信息清除
     * ps:  这里 myId 和 id 可以对应上   猜测是因为只有一个参数
     */
    @Override
    @Transactional
    @CacheEvict(value = "pageCache",key = "#myId")
    public void deleteById(Long id) {
        baseDao.deleteById(id);
    }





}