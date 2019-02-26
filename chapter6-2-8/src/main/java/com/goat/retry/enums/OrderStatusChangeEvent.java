package com.goat.retry.enums;

/**
 * Created by 64274 on 2019/2/26.
 *
 * @ Description: 订单状态改变事件
 * @ author  山羊来了
 * @ date 2019/2/26---23:00
 */
public enum OrderStatusChangeEvent {
    // 支付，发货，确认收货
    PAYED, DELIVERY, RECEIVED;
}