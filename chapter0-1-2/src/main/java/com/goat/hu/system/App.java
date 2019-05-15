package com.goat.hu.system;

import cn.hutool.system.HostInfo;
import cn.hutool.system.SystemUtil;
import org.junit.Test;

/**
 * Created by 64274 on 2019/5/15.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/15---17:02
 */
public class App {

    @Test
    public void test(){
        HostInfo hostInfo = SystemUtil.getHostInfo();
        System.out.println(hostInfo);
    }
}
