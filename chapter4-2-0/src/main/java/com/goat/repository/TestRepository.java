package com.goat.repository;

import com.goat.domain.MyMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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
public interface TestRepository extends JpaRepository<MyMoney, Long> {

    Optional<MyMoney> findById(Long id);

    @Transactional
    @Modifying
    @Query("UPDATE MyMoney SET col1 = col1 + :num WHERE id = :id")
    Integer updateMoney(@Param("num") Integer num, @Param("id") Long id);
}
