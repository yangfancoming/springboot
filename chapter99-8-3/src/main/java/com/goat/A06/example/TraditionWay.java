package com.goat.A06.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2019/3/7.
 * @ Description: 传统命令式解法实现的词频统计函数
 * @ author  山羊来了
 * @ date 2019/3/7---14:33
 */
public class TraditionWay extends IDoWordCount {

    /**
     * @param context          全文
     * @param auxiliaryWordSet 助词 结合
     * @Description: 统计 助词集合 在 全文中 出现的频率
     */
    @Override
    public Map<String,Integer> wordCount(List<String> context, List<String> auxiliaryWordSet) {
        System.out.println("传统命令式解法实现的词频统计函数");
        Map<String,Integer> result = new HashMap<>();
        for ( String word:context ) {  // 循环迭代
            String lowerCaseWord = word.toLowerCase();  // 将单词统一转换为小写
            if( !auxiliaryWordSet.contains(lowerCaseWord) ) {
                if( null == result.get(lowerCaseWord) )
                    result.put( lowerCaseWord, 1 );
                else
                    result.put( lowerCaseWord, result.get(lowerCaseWord)+1 );
            }
        }
        return result;
    }

    @Override
    public String connectWord(List<String> context) {
        System.out.println("传统命令式解法实现的词频统计函数");
        StringBuilder result = new StringBuilder();
        for ( String word: context ) {
            if ( word.length() > 1 ) {
                result.append( capitalizeFirstLetter(word) );
                result.append("-");
            }
        }
        return result.substring(0,result.length()-1);
    }



}
