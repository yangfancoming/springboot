package com.goat.A.A04.item04;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 64274 on 2019/8/3.
 *
 * @ Description:  实际的Builder
 * @ author  山羊来了
 * @ date 2019/8/3---10:47
 *
 *
 * 注意点：
 * 1）RedPacketBuilderImpl包含RedPacket的所有域
 * 2）set方法设置一个域，并且返回this，这是流式编程的关键
 * 3）最后build调用一个完整包含所有域的RedPacket构造函数
 */
public class RedPacketBuilderImpl implements RedPacketBuilder {

    private String publisherName;

    private String acceptName;

    private BigDecimal packetAmount;

    private int packetType;

    private Date pulishPacketTime;

    private Date openPacketTime;

    public static RedPacketBuilderImpl getBulider(){
        return new RedPacketBuilderImpl();
    }


    @Override
    public RedPacketBuilder setPublisherName(String publishName) {
        this.publisherName = publishName;
        return this;
    }

    @Override
    public RedPacketBuilder setAcceptName(String acceptName) {
        this.acceptName = acceptName;
        return this;
    }

    @Override
    public RedPacketBuilder setPacketAmount(BigDecimal packetAmount) {
        this.packetAmount = packetAmount;
        return this;
    }

    @Override
    public RedPacketBuilder setPacketType(int packetType) {
        this.packetType = packetType;
        return this;
    }

    @Override
    public RedPacketBuilder setPulishPacketTime(Date pushlishPacketTime) {
        this.pulishPacketTime = pushlishPacketTime;
        return this;
    }

    @Override
    public RedPacketBuilder setOpenPacketTime(Date openPacketTime) {
        this.openPacketTime = openPacketTime;
        return this;
    }


    public RedPacket build() {
        return new RedPacket(publisherName,acceptName,packetAmount,packetType,pulishPacketTime,openPacketTime);
    }
}
