package com.goat

import org.springframework.stereotype.Service

/**
 * Created by 64274 on 2018/11/29.
 * @Description: TODO* @author 山羊来了* @date 2018/11/29---13:32
 */
@Service("manService")
class ManServiceImpl implements ManService {
    @Override
    Man getInfoByName(String name) {
        return new Man(1,name,"1233131312312")
    }
}
