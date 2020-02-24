package com.goat.chapter453.repository;

import com.goat.chapter453.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

/**
 * 客户数据接口
 * 继承自 MongoRepository 接口
 *  当进行以下查询时，MongoRepository 提供的方法已经不能满足，
 *  根据实体类中的属性查询，定义方法名的规则为：find + By + 属性名（首字母大写）
    根据实体类中的属性进行模糊查询，定义方法名的规则为：find + By + 属性名（首字母大写） + Like，
 */
public interface CustomerRepository extends MongoRepository<User, String> {

     Optional<User> findById(String id);

     User findByName(String name);

     List<User> findByNameLike(String nam);
}
