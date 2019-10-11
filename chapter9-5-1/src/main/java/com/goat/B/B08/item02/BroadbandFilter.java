package com.goat.B.B08.item02;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: 具体过滤器角色：赠送移动宽带过滤器
 * @ author  山羊来了
 * @ date 2019/10/10---17:07
 */
public class BroadbandFilter implements Filter {

    @Override
    public List<Consumer> filtrate(List<Consumer> consumers) {
        // 手机套餐为138以上 赠送移动宽带100M一年
        List<Consumer> collect = consumers.stream().filter(x->x.getCombos() >= 138).collect(Collectors.toList());
        return collect;
    }
}
