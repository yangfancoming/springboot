package com.goat.A.A04.item04;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 64274 on 2019/8/3.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/8/3---10:48
 */
public class Director {

    public static void main(String[] args) {
        RedPacket redPacket = RedPacketBuilderImpl.getBulider().setPublisherName("lison")
                .setAcceptName("vip群")
                .setPacketAmount(new BigDecimal("888"))
                .setPacketType(1)
                .setOpenPacketTime(new Date())
                .setPulishPacketTime(new Date()).build();

        System.out.println(redPacket);
    }
}