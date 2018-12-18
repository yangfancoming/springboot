package A09.example01;

import org.testng.annotations.Test;

/**
     * @Description: 功能描述： 6.9 枚举类
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/3
*/

public class TestNG {

    @Test
    public void test5(){
        Season s = Season.WINTER;
        switch(s){ //JDK 1.5 之后，switch 支持枚举类型；且，case 后面可以直接书写枚举值，不需要限定
            case SPRING:
                System.out.println("Spring");
                break;
            case SUMMER:
                System.out.println("Summer");
                break;
            case FALL:
                System.out.println("Fall");
                break;
            case WINTER:
                System.out.println("Winter");
                break;
            default:
                System.out.println("11111");
                break;
        }
    }

}
