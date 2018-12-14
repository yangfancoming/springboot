package A05;

import org.testng.annotations.Test;

/**
     * @Description: 功能描述： 3.5.1 基本类型的自动转换 示例
     * @author: 杨帆
     * @Param:   byte -->  short/char --->  int ---> long ---> float ---> double
     * @Return:
     * @Date:   2018/9/3
*/

public class TestNG {

    @Test
    public void test(){
        System.out.println('a'+  1); // char ---> int    97+1=98
        System.out.println("a" + 1); // 字符串拼接     "a1"
    }

}
