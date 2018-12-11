package com.goat;

import com.goat.common.CommonNativeSqls;
import com.goat.repository.CustomerRepository;
import com.goat.repository.PersonRepository;
import com.goat.repository.PetRepository;
import com.goat.repository.UserRepository;
import com.goat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 64274 on 2018/9/28.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/28---16:06
 */
public class TestCommon {

    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CustomerRepository customerRepository;

    @Autowired
    public PersonRepository personRepository;
    @Autowired
    public PetRepository petRepository;

    @Autowired
    public UserService userService;

    @Autowired
    public CommonNativeSqls commonNativeSqls;

}
