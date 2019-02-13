package com.goat.repository;

import com.goat.model.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 64274 on 2019/2/13.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/13---17:53
 */
public interface MyTableRepository extends JpaRepository<MyTable, Long> {}
