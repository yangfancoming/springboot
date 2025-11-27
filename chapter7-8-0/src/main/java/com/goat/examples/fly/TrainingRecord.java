package com.goat.examples.fly;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by 64274 on 2025/11/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2025/11/27---14:22
 *
 * 训练设备 / 仪表 / PF/PM）
 *
 * 表2内容本质上是：
 *
 * ✅ 设备
 * ✅ 仪表飞行
 * ✅ PF/PM
 * ✅ 昼 / 夜
 * ✅ 着陆统计
 *
 */
public class TrainingRecord  implements FlightEvent{

    String pilotId;
    LocalDate date;

    DeviceType deviceType; // 模拟机 / 训练器 / 高级训练设备
    String aircraftModel;

    BigDecimal trainingTime;
    BigDecimal instructionTime;

    // PF / PM
    OperationRole operationRole;

    Integer dayLandings;
    Integer dayFullStop;

    Integer nightLandings;
    Integer nightFullStop;

    String approachType;
    BigDecimal instrumentTime;
    BigDecimal nightTime;

    @Override
    public String getPilotId() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }
}
