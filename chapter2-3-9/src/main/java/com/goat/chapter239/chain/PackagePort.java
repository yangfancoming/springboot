package com.goat.chapter239.chain;

import cn.goatool.core.util.ByteArrayUtil;
import com.goat.chapter239.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/11/18.
 *
 * @ Description: 本地移动端口  2bytes
 * @ author  山羊来了
 * @ date 2019/11/18---12:01
 */
@Component
public class PackagePort extends Chain {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public ByteArrayInputStream handler(ByteArrayInputStream input) throws IOException {
        byte[] port = new byte[2];
        input.read(port);
        Message.packagePort = port;
        Message.port = ByteArrayUtil.byteArrToShort(Message.packagePort);
        log.info("本地移动端口 解析结果： " + Message.port );
        log.info("本地移动端口 解析结果（16进制）： "+ ByteArrayUtil.byteArrToHexString(port));
        return process(input);
    }
}
