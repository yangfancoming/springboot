package A09.example02;

/**
 * Created by 64274 on 2018/9/11.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/11---10:43
 */
public enum Weekday {

    //    SUN,MON,TUS,WED,THU,FRI,SAT
    SUN(0),MON(1),TUS(2),WED(3),THU(4),FRI(5),SAT(6);

    private int value;

     Weekday(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Weekday getNextDay(Weekday nowDay){
        int nextDayValue = nowDay.value;

        if (++nextDayValue == 7){
            nextDayValue =0;
        }

        return getWeekdayByValue(nextDayValue);
    }

    public static Weekday getWeekdayByValue(int value) {
        for (Weekday c : Weekday.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
    }
}
