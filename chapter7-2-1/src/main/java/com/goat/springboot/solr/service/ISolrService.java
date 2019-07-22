package com.goat.springboot.solr.service;

import com.goat.springboot.solr.model.User;

import java.util.List;

/**
 * Created by 64274 on 2019/7/22.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/22---10:21
 */
public interface ISolrService {

    List<User> addUser();
}
