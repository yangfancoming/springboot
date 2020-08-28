package cn.goatool.core.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/8/28.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/8/28---15:03
 */
public class ListUtils {


    // List每次取 batchCount 条进行处理
    public static void dealBySubList(List<Object> sourList, int batchCount){
        int sourListSize = sourList.size();
        int subCount = sourListSize%batchCount==0 ? sourListSize/batchCount : sourListSize/batchCount+1;
        int startIndext = 0;
        int stopIndext = 0;
        for(int i=0;i<subCount;i++){
            stopIndext = (i==subCount-1) ? stopIndext + sourListSize%batchCount : stopIndext + batchCount;
            List<Object> tempList = new ArrayList<>(sourList.subList(startIndext, stopIndext));
            System.out.println(tempList);
            startIndext = stopIndext;
        }
    }


}
