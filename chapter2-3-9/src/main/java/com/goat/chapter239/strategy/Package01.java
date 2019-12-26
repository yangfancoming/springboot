package com.goat.chapter239.strategy;


import com.goat.chapter239.chain.Chain;
import com.goat.chapter239.chain.ChainService;
import com.goat.chapter239.model.Dtu;
import com.goat.chapter239.model.Message;
import com.goat.chapter239.util.SpringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.util.Date;

/**
 * Created by Administrator on 2019/11/18.
 * @ Description: 0x01 终端请求注册   dtu --->>> dsc
 * [7B 01 00 16 31 33 39 30 30 30 30 30 30 30 30 AC 18 6A 02 13 89 7B ] 7B0100163133393030303030303030AC186A0213897B
 * [7B 81 00 10 31 33 39 30 30 30 30 30 30 30 30 7B ]
 * @ author  山羊来了
 * @ date 2019/11/18---13:22
 */
@Component
public class Package01 implements PackageTypeJudge {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Integer type() {
        return 0x01;
    }

    @Override
    public Chain initChain() {
        ChainService chainService = (ChainService) SpringUtils.getBean("chainService");
        return chainService.getChain1();
    }

    @Override
    public byte[] analysis(ByteArrayInputStream inputStream) {
        Message.packageType = new byte[]{ (byte) 0x81} ;
        Message.packageLength = new byte[]{0x00,0x10};
        byte[] bytes = Message.byteMerger(16);
        Dtu dtu = new Dtu();
        dtu.setIdentity(Message.identity);
        dtu.setIp(Message.ip);
        dtu.setPort(Message.port);
        dtu.setTime(new Date());
        Message.register.put(Message.identity,dtu);
        log.info("添加注册成功dtu："+ Message.identity);
        return bytes;
    }



}
