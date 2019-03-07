package com.goat.A06.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/3/7.
 * @ Description: 函数式解法   lambda 解法
 * @ author  山羊来了
 * @ date 2019/3/7---14:34
 */
public class LambdaWay extends IDoWordCount {

    /**
     * @param context          全文
     * @param auxiliaryWordSet 助词 结合
     * @Description: 统计 助词集合 在 全文中 出现的频率
     */
    @Override
    public Map<String, Integer> wordCount(List<String> context, List<String> auxiliaryWordSet) {
        System.out.println("函数式解法");
        Map<String,Integer> result = new HashMap<>();
        context.stream().map( w -> w.toLowerCase() )
                .filter( w -> !auxiliaryWordSet.contains(w) )
                .forEach( w -> result.put( w, result.getOrDefault(w,0) + 1 ) );
        return result;
    }

    @Override
    public String connectWord(List<String> context) {
        System.out.println("函数式解法");
        return context.stream().filter( w -> w.length()>1 )
                .map( w -> capitalizeFirstLetter(w) )
                .collect( Collectors.joining("-") );
    }
}
