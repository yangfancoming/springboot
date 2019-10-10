package com.goat.B.B08.item02;

import java.util.ArrayList;
import java.util.List;

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
        List<Consumer> cs = new ArrayList<Consumer>();
        // 手机套餐为138以上 赠送移动宽带100M一年
        for (Consumer c : consumers) {
            if (c.getCombos() >= 138) {
                cs.add(c);
            }
        }
        return cs;
    }
}
