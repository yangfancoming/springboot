package com.goat.service.impl;


import com.goat.bean.Person;
import com.goat.service.PersonService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    /**缓存名称 people   数据的key是 person的 id  如果没有指定key属性 那么方法参数作为key保存到缓存中 */
    @Override
    @Cacheable(value = "people", key = "#p.id") /**主要在查询方法，可以根据方法的请求参数对其结果进行缓存，如果缓存中存在 则不进入该方法*/
    public Person findOne(Person p) {
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }


    @Override
    @CachePut(value = "people", key = "#p.id") /** 主要用户更新方法，保证被调用，又希望结果被缓存，不论缓存中是否存在该数据，均进入该方法*/
    public Person save(Person p) {
        System.out.println("为id、key为:" + p.getId() + "数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people") /**主要用在删除方法 清空缓存 */
    public void remove(Long id) {
        System.out.println("删除了id、key为" + id + "的数据缓存");
    }


}
