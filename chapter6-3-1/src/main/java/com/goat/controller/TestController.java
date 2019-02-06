package com.goat.controller;

import com.goat.dynamicTask.DynamicScheduledConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by 64274 on 2019/2/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/7---0:51
 */
@Controller
public class TestController {

    @Autowired
    DynamicScheduledConfig dynamicScheduledConfig;

    /**
     *  修改动态定时任务的cron值  每3秒执行一次
     *  http://localhost:8631/updateTask
    */
    @GetMapping("/updateTask")
    public Object updateTask() {
        dynamicScheduledConfig.setCron("0/3 * * * * ?");
        return "success";
    }

}
