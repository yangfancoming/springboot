package com.goat.chapter239.chain;

import com.goat.chapter239.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/11/18.
 *
 * @ Description: 本地移动 IP  4bytes
 *  AC 18 6A 02   172.24.106.2
 * @ author  山羊来了
 * @ date 2019/11/18---12:01
 */
@Component
public class PackageIp extends Chain {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public ByteArrayInputStream handler(ByteArrayInputStream input) throws IOException {
        byte[] ip = new byte[4];
        input.read(ip);
        Message.packageIp = ip;
        Message.ip = (ip[0] & 0xff) + "." + (ip[1] & 0xff) + "." + (ip[2] & 0xff) + "." + (ip[3] & 0xff);
        log.info("本地移动 IP 解析结果： " + Message.ip );
        return process(input);
    }
}
