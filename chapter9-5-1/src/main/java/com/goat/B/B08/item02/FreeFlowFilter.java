package com.goat.B.B08.item02;

import java.util.ArrayList;
import java.util.List;

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
        List<Consumer> cs = new ArrayList<Consumer>();
        // 在网年份大于5年 赠送10G移动流量
        for (Consumer c : consumers) {
            if (c.getExistsYears() >= 5) {
                cs.add(c);
            }
        }
        return cs;
    }
}

