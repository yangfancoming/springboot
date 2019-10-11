package com.goat.B.B08.item02;

import java.util.List;
import java.util.stream.Collectors;

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
        // 星级为5星级以上 赠送生日提醒
        List<Consumer> collect = consumers.stream().filter(x->x.getStar() >= 5).collect(Collectors.toList());
        return collect;
    }
}

