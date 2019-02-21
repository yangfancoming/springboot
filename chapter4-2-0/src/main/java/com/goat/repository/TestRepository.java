package com.goat.repository;

import com.goat.domain.MyMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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
//    @Query("UPDATE MyMoney SET col1 = :num WHERE id = :id")
    @Query("UPDATE MyMoney SET col1 = :num,version=:version+1 WHERE id = :id and version=:version ")
    Integer updateMoney(@Param("num") String num, @Param("id") Long id);
}
