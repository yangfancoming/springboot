package com.goat.repository;

import com.goat.domain.MyMoney;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


/**
 * Created by 64274 on 2018/9/28.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/28---17:21
 *
 * Customer 实体类
 * Long 主键ID 类型
 */
public interface TestRepository extends CrudRepository<MyMoney, Long> {

    Optional<MyMoney> findById(Long id);



}
