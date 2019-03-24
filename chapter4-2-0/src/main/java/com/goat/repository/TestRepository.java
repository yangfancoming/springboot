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
//    @Query("UPDATE MyMoney SET col1 = :num WHERE id = :id") Named parameter [version] not set
    @Query("UPDATE MyMoney SET col1 = :num,version=:version+1 WHERE id = :id and version=:version ")
    Integer updateMoney(@Param("num") String num, @Param("id") Long id, @Param("version") Long version);


    /**
        sql  报错： Parameter value [0] did not match expected type [java.lang.Integer (n/a)];
     解决方法：  MyMoney 改成  t_money  再加上  nativeQuery = true
    */

    @Transactional
    @Modifying
    @Query(value = "UPDATE t_money SET col1 = :num,version=:version+1 WHERE id = :id and version=:version ",nativeQuery = true)
    Integer updateMoney2(@Param("num") String num, @Param("id") Long id, @Param("version") Long version);

}
