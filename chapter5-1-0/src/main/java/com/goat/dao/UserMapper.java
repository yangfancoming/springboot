package com.goat.dao;



import com.goat.bean.User;

import java.util.Map;

/**
 * Created by 64274 on 2018/11/13.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/11/13---13:30
 */

public interface  UserMapper extends SuperMapper<User>  {

    Map findMapById(Integer id);
}
