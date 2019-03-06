package com.goat.repository;

import com.goat.domain.Order;
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
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = " from Order where id in (:ids)")
    List<Order>  findbyids(@Param("ids") List<Long> ids);
}
