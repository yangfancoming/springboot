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
 * @ Description: 用户数据  长度为N  TCP协议
 * [7B 09 00 10 31 33 39 30 30 30 30 30 30 30 30 31 32 33 7B ] 其中 31 32 33 为用户数据
 * @ author  山羊来了
 * @ date 2019/11/18---12:01
 */
public class PackageUserTcp extends Chain {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    Starter starter;

    @Override
    public ByteArrayInputStream handler(ByteArrayInputStream input) throws IOException {
        // 取出 31 32 33 7B
        byte[] user = new byte[input.available()];
        input.read(user);
        byte[] result = new byte[user.length-1];
        // 将  31 32 33 7B 中的 31 32 33 拷贝到目的数组
        System.arraycopy(user, 0, result, 0, user.length-1);
        log.info("TCP   用户数据 解析长度： " + result.length );
        log.info("TCP   用户数据 解析结果（16进制）： " + ByteArrayUtils.byteArrToHexString(result));
        starter.start(result);
        return process(input);
    }
}
