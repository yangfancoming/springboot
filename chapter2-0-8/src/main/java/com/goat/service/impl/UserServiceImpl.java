
package com.goat.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.goat.bean.User;
import com.goat.dao.UserMapper;
//import com.goat.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author stylefeng123
 * @since 2018-02-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> {

    public Map findMapById(Integer id) {
        return this.baseMapper.findMapById(id);
    }

}
