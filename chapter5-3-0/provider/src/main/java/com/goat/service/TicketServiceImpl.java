package com.goat.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * Created by 64274 on 2018/10/26.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/26---17:01
 */

@Service // 这里是 dubbo 的 service注解  发布出去
@Component
public class TicketServiceImpl implements ITicketService {
    @Override
    public String getTicket() {
        return "sdfadfdubbo!";
    }
}
