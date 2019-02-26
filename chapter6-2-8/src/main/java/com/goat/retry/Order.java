package com.goat.retry;

import com.goat.retry.enums.OrderStatus;

/**
 * Created by 64274 on 2019/2/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/26---23:14
 */
public class Order {
    OrderStatus status;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
