package com.goat.A06.example;

import java.util.List;
import java.util.Map;


public abstract class IDoWordCount {

    /**
     * @Title：
     * @Description:  统计 助词集合 在 全文中 出现的频率
     * @author fan.yang
     * @date 2019/3/7.
     * @param context  全文
     * @param auxiliaryWordSet  助词 结合
     */

    abstract Map<String,Integer> wordCount(List<String> context, List<String> auxiliaryWordSet);

    abstract String connectWord( List<String> context );

    // 将单词的首字母大写
    public String capitalizeFirstLetter( String s ) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }


}
