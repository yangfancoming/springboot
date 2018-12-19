package com.goat.repository;

import com.goat.domain.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


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
public interface MyTableRepository extends JpaRepository<MyTable, Long> {


//    @Query("select u from User u where u.name = :name")
//    List<MyTable> findUser(@Param("id") String id);


}
