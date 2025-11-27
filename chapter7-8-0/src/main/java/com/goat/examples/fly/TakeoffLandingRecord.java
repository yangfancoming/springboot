package com.goat.examples.fly;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by 64274 on 2025/11/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2025/11/27---14:24
 *
 *
 * 起飞 / 着陆 / 距离
 *
 */
public class TakeoffLandingRecord  implements FlightEvent{
    String pilotId;

    LocalDate date;
    Integer takeoffCount;
    Integer landingCount;

    BigDecimal straightDistanceKm;

    @Override
    public String getPilotId() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }
}
