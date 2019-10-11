package com.goat.B.B08.item02;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: 具体过滤器角色：赠送流量过滤器
 * @ author  山羊来了
 * @ date 2019/10/10---17:07
 */
public class FreeFlowFilter implements Filter {

    @Override
    public List<Consumer> filtrate(List<Consumer> consumers) {
        // 在网年份大于5年 赠送10G移动流量
        List<Consumer> collect = consumers.stream().filter(x->x.getExistsYears() >= 5).collect(Collectors.toList());
        return collect;
    }
}

