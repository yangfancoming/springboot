package com.goat.chapter239.strategy;



import com.goat.chapter239.chain.Chain;

import java.io.ByteArrayInputStream;

public interface PackageTypeJudge {

    /**
     * 0x01 终端请求注册 GPRS
     * 0x02 终端请求注销 GPRS
     * 0x04 无效命令或协议包（一般在查询或设置指令时使用） GPRS
     * 0x05 接收到 dsc 用户数据的应答包 GPRS
     * 0x09 发送给 dsc 的用户数据包 GPRS
     * 0x0B 查询 DTU 参数的应答包 GPRS
     * 0x0D 设置 DTU 参数的应答包 GPRS/SMS
     * 0x0E 提取 DTU 日志的应答包 GPRS
     * 0x0F 远程升级的回应包 GPRS/SM
    */
    Integer type();

    /**  初始化处理链 */
    Chain initChain();

    /**   */
    byte[] analysis(ByteArrayInputStream inputStream);

}
