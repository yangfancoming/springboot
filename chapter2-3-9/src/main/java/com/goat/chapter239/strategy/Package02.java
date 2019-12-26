package com.goat.chapter239.strategy;

import com.goat.chapter239.chain.Chain;
import com.goat.chapter239.chain.ChainService;
import com.goat.chapter239.model.Message;
import com.goat.chapter239.util.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

/**
 * Created by Administrator on 2019/11/18.
 * @ Description: 0x02 终端请求注销
 * [7B 02 00 10 31 33 39 30 30 30 30 30 30 30 30 7B ]
 * [7B 82 00 10 31 33 39 30 30 30 30 30 30 30 30 7B ]
 * @ author  山羊来了
 * @ date 2019/11/18---13:22
 */
@Component
public class Package02 implements PackageTypeJudge {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Integer type() {
        return 0x02;
    }

    @Override
    public Chain initChain() {
        ChainService chainService = (ChainService) SpringUtils.getBean("chainService");
        return chainService.getChain();
    }

    @Override
    public byte[] analysis(ByteArrayInputStream inputStream) {
        log.info("Package02");
        Message.packageType = new byte[]{ (byte) 0x82} ;
        Message.packageLength = new byte[]{0x00,0x10};
        byte[] bytes = Message.byteMerger(16);
        Message.register.remove(Message.identity);
        log.info("注销dtu成功",Message.identity);
        return bytes;
    }


}
