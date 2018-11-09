package com.goat.repository;

import com.goat.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**

 当进行以下查询时，JpaRepository 提供的方法已经不能满足，
 根据实体类中的属性查询，定义方法名的规则为：find + By + 属性名（首字母大写）
 根据实体类中的属性进行模糊查询，定义方法名的规则为：find + By + 属性名（首字母大写） + Like，

 注意： @Query 注解中的 sql 语句  表明 必须是 实体类名！！！ 直接写表明会报错的！！

 */

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

    List<User> findByNameLike(String nam); // 需要 再参数中设定 模糊查询符号 %  很蛋疼

    User findByNameAndAge(String name, Integer age);


    @Query("select u from User u where u.name = :name")
    List<User> findUser(@Param("name") String name);


    @Transactional // 没有该注解 会报“Executing an update/delete query”的错
    @Modifying // 没有该注解 会报 Not supported for DML operations [UPDATE com.goat.domain.User SET name = :name WHERE id = :id]
    @Query("UPDATE User SET name = :name WHERE id = :id")
    Integer updateUser(@Param("name") String name,@Param("id") Long id);

    long countByAge(Integer age);
}
