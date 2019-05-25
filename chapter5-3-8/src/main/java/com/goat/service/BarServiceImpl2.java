
package com.goat.service;

import com.alibaba.dubbo.config.annotation.Service;


@Service(version = "2.0.0")
public class BarServiceImpl2 implements IBarService {

    @Override
    public String testMutiVersion() {
        return "version2";
    }
}
