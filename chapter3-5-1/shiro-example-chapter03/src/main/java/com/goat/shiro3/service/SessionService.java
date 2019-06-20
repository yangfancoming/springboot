package com.goat.shiro3.service;

import com.goat.shiro3.bean.UserOnline;

import java.util.List;

/**
 * Created by 64274 on 2019/6/20.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/20---9:15
 */
public interface SessionService {

    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
