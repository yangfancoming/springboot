package com.goat.repository;

import com.goat.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CumDemoRepository extends JpaRepository<Order, Long> {

    /**
     JPA 原生sql 查询返回 自定义属性
    */
    @Query(value = "SELECT a.id,a.money,SUM(lt.money) as cum FROM cum_demo a JOIN cum_demo lt  ON a.id >= lt.id GROUP BY a.money ORDER BY id",nativeQuery = true)
    List<Object[]> test();
}
