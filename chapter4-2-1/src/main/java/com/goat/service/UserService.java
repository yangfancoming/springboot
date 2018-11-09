package com.goat.service;

import com.goat.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by 64274 on 2018/9/14.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/14---16:17
 */
@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveAll(List<User> list) {
        for (int i = 0; i < list.size(); i++) {
            entityManager.persist(list.get(i));
        }
        entityManager.flush();
        entityManager.clear();
    }
}
