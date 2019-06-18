package com.goat.tinypinyin;

import com.github.promeg.pinyinhelper.Pinyin;
import com.github.promeg.pinyinhelper.PinyinMapDict;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64274 on 2019/6/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/18---9:44
 */
public class App {



    // 1 根据一个字符转成拼音，如果该字符不是汉字就显示该字符，否则转成拼音（下面几个API一样）
    @Test
    public void test1(){
        String s= Pinyin.toPinyin('梁');
        System.out.println(s); // LIANG
    }

    // 2 根据一个字符串转成拼音  "/"表示分割符，每个拼音之间的分割的符号
    @Test
    public void test2(){
        String s = Pinyin.toPinyin("梁超杰","/");
        System.out.println(s); // LIANG/CHAO/JIE
    }

    //3 判断一个字符是不是汉字？
    @Test
    public void test3(){
        boolean mark = Pinyin.isChinese('梁');
        System.out.println(mark);
    }
    /** 4 处理多音字
     举个例子：你的联系人有一个人姓解，这是一个多音字（XIE和JIE）
     但是这个库默认转换的拼音可能和你的叫法不一致，所以下面这个就派上用场了
    */
    @Test
    public void test4(){
        MyPinyinMapDict myPinyinMapDict = new MyPinyinMapDict();
        // 添加自定义词典
        Pinyin.init(Pinyin.newConfig().with(myPinyinMapDict));
        String s = Pinyin.toPinyin("解元","/");
        System.out.println(s); // XIE/YUAN
    }

}
