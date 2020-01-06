package com.goat.chapter239.chain;

import cn.goatool.core.util.ByteArrayUtils;
import com.goat.chapter239.observe.Starter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/11/18.
 *
 * @ Description: 用户数据  长度为N
 * @ author  山羊来了
 * @ date 2019/11/18---12:01
 */
public class PackageUserUdp extends Chain {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    Starter starter;

    @Override
    public ByteArrayInputStream handler(ByteArrayInputStream input) throws IOException {
        log.info("用户数据 处理器: " + input.available());
        byte[] user = new byte[input.available()-1]; // doit
        input.skip(1);// 跳过最后一个 7B 剩下的都是 用户数据 (udp协议)
        input.read(user);
        log.info("UDP 用户数据 解析结果： " + user );
        log.info("UDP 用户数据 解析结果（16进制）： " + ByteArrayUtils.byteArrToHexString(user));
        starter.start(user);
        return process(input);
    }
}
