package com.goat.A06.example;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by 64274 on 2019/3/7.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/7---13:55
 */
public class WordCount {
    List<String> context = Arrays.asList("The","Products","of","Samsung","and","Apple","are","so","amazing","especially","Apple");
    List<String> auxiliaryWordSet = Arrays.asList("of","the","of","to","and","so","are");

    @Test
    public void test1(){
        IDoWordCount iDoWordCount = new TraditionWay();
        Map res = iDoWordCount.wordCount(context, auxiliaryWordSet);
        System.out.print(res);
    }

    @Test
    public void test2(){
        IDoWordCount iDoWordCount = new LambdaWay();
        Map res = iDoWordCount.wordCount(context, auxiliaryWordSet);
        System.out.print(res);
    }

    // The-Products-Of-Samsung-And-Apple-Are-So-Amazing-Especially-Apple
    @Test
    public void test3(){
        IDoWordCount iDoWordCount = new TraditionWay();
        String res = iDoWordCount.connectWord( context );
        System.out.print(res);
    }

    @Test
    public void test4(){
        IDoWordCount iDoWordCount = new LambdaWay();
        String res = iDoWordCount.connectWord( context );
        System.out.print(res);
    }

// "❤"  很神奇的 心型
}
