package com.goat.A.A04.item04;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 64274 on 2019/8/3.
 *
 * @ Description:  Builder抽象接口
 * @ author  山羊来了
 * @ date 2019/8/3---10:46
 */
public interface RedPacketBuilder {

    RedPacketBuilder setPublisherName(String publishName);

    RedPacketBuilder setAcceptName(String acceptName);

    RedPacketBuilder setPacketAmount(BigDecimal packetAmount);

    RedPacketBuilder setPacketType(int packetType);

    RedPacketBuilder setPulishPacketTime(Date pushlishPacketTime);

    RedPacketBuilder setOpenPacketTime(Date openPacketTime);

    RedPacket build();

}
