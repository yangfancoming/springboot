package com.goat.dao;

import com.goat.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by 64274 on 2019/3/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/4---15:17
 */
public interface BaseDaoRepository extends JpaRepository<User, Long> {


}
