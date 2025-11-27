package com.goat.mytest.fly;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by 64274 on 2025/11/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2025/11/27---14:25
 */
public class PICRecord  implements FlightEvent{

    String pilotId;

    LocalDate date;
    AircraftCategory category;

    BigDecimal picHours;

    @Override
    public String getPilotId() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }
}
