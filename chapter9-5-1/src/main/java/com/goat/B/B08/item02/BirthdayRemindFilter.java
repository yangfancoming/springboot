package com.goat.B.B08.item02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/10/10.
 *
 * @ Description: 具体过滤器角色：生日提醒过滤器
 * @ author  山羊来了
 * @ date 2019/10/10---17:07
 */
public class BirthdayRemindFilter implements Filter {

    @Override
    public List<Consumer> filtrate(List<Consumer> consumers) {
        List<Consumer> cs = new ArrayList<Consumer>();
        // 星级为5星级以上 赠送生日提醒
        for (Consumer c : consumers) {
            if (c.getCombos() >= 138) {
                cs.add(c);
            }
        }
        return cs;
    }
}

