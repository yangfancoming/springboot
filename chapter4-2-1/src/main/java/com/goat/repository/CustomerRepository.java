package com.goat.repository;

import com.goat.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //接口方法的名称，符合约定则无需实现即可访问
    List<Customer> findByLastName(String lastName);
    List<Customer> findByLastNameOrFirstName(String lastName,String firstName);


    // doit？ queryDistinctBy  findDistinctBy  要怎么查询？
    public List<Customer> queryDistinctByFirstName(String first);
}

