package com.goat.service;

//import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * Created by 64274 on 2018/10/26.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/10/26---17:02
 */
@Service
public class UserService {
    @Resource
    ITicketService iTicketService;

    public void hello(){
        iTicketService.getTicket(); // doit  这里为 null  还是 zookeeper 没有注册上  ？
        System.out.println("12322222");
    }
}
