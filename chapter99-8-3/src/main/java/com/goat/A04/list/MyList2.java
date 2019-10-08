package com.goat.A04.list;


import com.goat.A04.BaseListData;
import org.junit.Test;


/**
     * @Description:
     * @author: Goat
     * @Date:  2018年12月26日18:52:32
*/
public class MyList2 extends BaseListData {

/**
 *

*/
    @Test
    public void test()  {
        int i = list1.indexOf("3");
        System.out.println(i);

        int i2 = list1.indexOf("11");
        System.out.println(i2);

        String remove = list1.remove(- 1);
        System.out.println(remove);
    }




}
