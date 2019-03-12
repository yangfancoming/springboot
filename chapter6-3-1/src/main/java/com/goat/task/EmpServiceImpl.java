package com.goat.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 64274 on 2018/8/20.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/20---17:48
 *
 * 字段	 	允许值	 	允许的特殊字符
 * 秒	 	0-59	 	, - * /
 * 分	 	0-59	 	, - * /
 * 小时	 	0-23	 	, - * /
 * 日期	 	1-31	 	, - *   / L W C
 * 月份	 	1-12 或者 JAN-DEC	 	, - * /
 * 星期	 	1-7 或者 SUN-SAT	 	, - *   / L C #
 * 年（可选）	 	留空, 1970-2099	 	, - * /
 * <p>
 * “*”字符被用来指定所有的值。如：”*“在分钟的字段域里表示“每分钟”。
 * “-”字符被用来指定一个范围。如：“10-12”在小时域意味着“10点、11点、12点”。
 * “,”字符被用来指定另外的值。如：“MON,WED,FRI”在星期域里表示”星期一、星期三、星期五”.
 * “?”字符只在日期域和星期域中使用。它被用来指定“非明确的值”。当你需要通过在这两个域中的一个来指定一些东西的时候，它是有用的。看下面的例子你就会明白。
 * “L”字符指定在月或者星期中的某天（最后一天）。即“Last ”的缩写。但是在星期和月中“Ｌ”表示不同的意思，如：在月子段中“L”指月份的最后一天-1月31日，2月28日，如果在星期字段中则简单的表示为“7”或者“SAT”。如果在星期字段中在某个value值得后面，则表示“某月的最后一个星期value”,如“6L”表示某月的最后一个星期五。
 * “W”字符只能用在月份字段中，该字段指定了离指定日期最近的那个星期日。
 * “#”字符只能用在星期字段，该字段指定了第几个星期value在某月中
 */
//@Service
public class EmpServiceImpl   {

    @Scheduled(fixedRate = 5 * 1000)
    public void test0() {
        System.out.println("固定每5秒执行一次");
    }

    @Scheduled(fixedRate = 5 * 1000)
    public void test() {
        System.out.println("固定每5秒执行一次");
    }

    @Scheduled(cron = "0/10 * * * * ? ")
    public void doJobByCron() {
        System.out.println(new Date() + "每10秒执行一次");
    }

    @Scheduled(cron = "0 */1 *  * * * ")
    public void test1() {
        System.out.println("每分钟执行一次");
    }

    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
    public void test2() {
        System.out.println("周一至周六无论哪一天 0,1,2,3,4这几秒都会执行.。。。。。。。。。。。");
    }

    @Scheduled(cron = "0-4 * * * * MON-SAT")
    public void test3() {
        System.out.println("周一至周六无论哪一天 0,1,2,3,4这几秒都会执行");
    }

    @Scheduled(cron = "0 0 2 * * ?")
    public void test4() {
        System.out.println("每天凌晨2点 执行");
    }

    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void doInitialDelay() {
        System.out.println(new Date() + "第一次延迟1秒后执行，之后按fixedRate的规则每2秒执行一次");
    }

    @Scheduled(fixedDelay = 1 * 1000)
    public void doJobByFixedDelay() {
        System.out.println(new Date() + "上次任务结束后一秒后再次执行");
    }
}
