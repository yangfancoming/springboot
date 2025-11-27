package com.goat.examples.fly;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by 64274 on 2025/11/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2025/11/27---14:23
 *
 * 长转场飞行
 */
public class CrossCountryRecord  implements FlightEvent{
    String pilotId;

    LocalDate date;
    String fromAirport;
    String toAirport;

    BigDecimal distanceKm;   // 直线距离

    Boolean asPIC;

    @Override
    public String getPilotId() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }
}
