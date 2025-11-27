package com.goat.examples.fly;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by 64274 on 2025/11/27.
 *
 * 飞行时间分类表
 * 通常是飞行经历分类统计表
 *
 * 用于判断：
 *
 * 被带飞时间
 *
 * 单飞时间
 *
 * PIC经验
 *
 * 机型类别
 *
 * 飞机类型
 *
 * 执照口径
 *
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2025/11/27---14:18
 */
public class FlightTimeRecord implements FlightEvent{

    String pilotId;           // 飞行员ID
    LocalDate flightDate;

    // 表1 第2项：航空器时间分类
    AircraftCategory aircraftCategory;
    // 枚举: 单发陆地 / 单发水上 / 初级飞机陆地 / 多发 / 滑翔机 / 自转旋翼机 / 小型飞艇 / 自由气球 等

    // 第7项：时间类型
    RoleType roleType;
    // 枚举：带飞 / 单飞 / PIC / 双驾 / 教员 / 学员

    // 飞行时间
    BigDecimal flightHours;

    String aircraftModel;

    // 是否计入规则
    Boolean valid;

    @Override
    public String getPilotId() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }
}
