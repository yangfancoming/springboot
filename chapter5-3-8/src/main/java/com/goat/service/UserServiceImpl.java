
package com.goat.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.dao.UserMapper;
import com.goat.entity.User;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service // 对外暴露服务实现  暴露类中的所有方法！
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Map findMapById(Integer id) {
        return baseMapper.findMapById(id);
    }

    @Override
    public User selectByUsername(String username) {
        System.out.println(2222);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(11,"jordan");
    }


}
