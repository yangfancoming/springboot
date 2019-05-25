
package com.goat.service;

import com.alibaba.dubbo.config.annotation.Service;



@Service(version = "1.0.0")
public class BarServiceImpl1 implements IBarService {

    @Override
    public String testMutiVersion() {
        return "version1";
    }
}
