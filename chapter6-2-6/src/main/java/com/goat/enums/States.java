package com.goat.enums;



/**
 * @Description:
 * @author: 杨帆
 * @Date:   2018/12/25
 *
 * 其中共有三个状态（待支付、待收货、结束）以及两个引起状态迁移的事件（支付、收货），
 * 其中支付事件PAY 会触发状态从待支付 UNPAID 状态到待收货 WAITING_FOR_RECEIVE 状态的迁移，
 * 而收货事件 RECEIVE 会触发状态从待收货 WAITING_FOR_RECEIVE 状态到结束 DONE 状态的迁移。
 */

public enum States {
    UNPAID,                 // 待支付
    WAITING_FOR_RECEIVE,    // 待收货
    DONE                    // 结束
}
