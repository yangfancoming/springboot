package com.goat.controller;

import com.goat.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 64274 on 2019/2/8.
 *
 * @ Description: 父类不需要 @RestController 注解  因为 子类无法继承 该注解
 * @ author  山羊来了
 * @ date 2019/2/8---18:23
 */
public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public CustomerRepository repository;

}
