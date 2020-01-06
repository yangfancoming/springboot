package com.goat.chapter239.chain;

import cn.goatool.core.util.ByteArrayUtils;
import com.goat.chapter239.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/11/18.
 *
 * @ Description: 包长度处理器
 * @ author  山羊来了
 * @ date 2019/11/18---12:01
 */
@Component
public class PackageLength extends Chain {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public ByteArrayInputStream handler(ByteArrayInputStream input) throws IOException {
        byte[] length = new byte[2];
        input.read(length);
        Message.packageLength = length;
        log.info("包长度处理器 解析结果： "+ ByteArrayUtils.byteArrToShort(Message.packageLength));
        log.info("包长度处理器 解析结果（16进制）："+ ByteArrayUtils.byteArrToHexString(length));
        return process(input);
    }
}
