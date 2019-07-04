package com.goat.hsqldb.dao;

import com.goat.hsqldb.model.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 64274 on 2019/7/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/4---18:35
 */
public interface DemoDao extends CrudRepository<Demo, Long> {
    Demo findByName(String name);
}