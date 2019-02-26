package com.goat.retry.enums;

/**
 * Created by 64274 on 2019/2/26.
 *
 * @ Description: 订单状态
 * @ author  山羊来了
 * @ date 2019/2/26---23:00
 */

public enum OrderStatus {
    // 待支付，待发货，待收货，订单结束
    WAIT_PAYMENT, WAIT_DELIVER, WAIT_RECEIVE, FINISH
}