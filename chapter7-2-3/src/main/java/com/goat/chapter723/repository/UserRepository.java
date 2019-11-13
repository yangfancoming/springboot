package com.goat.chapter723.repository;

import com.goat.chapter723.entity.User;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;


public interface UserRepository extends SolrCrudRepository<User, Long> {

    public List<User> findByUsernameContains(String username);


}
