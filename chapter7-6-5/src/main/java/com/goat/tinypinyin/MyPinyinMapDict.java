package com.goat.tinypinyin;

import com.github.promeg.pinyinhelper.PinyinMapDict;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 64274 on 2019/6/18.
 * 测试
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/18---9:53
 */
public class MyPinyinMapDict extends PinyinMapDict {
    /**
     * Key为字典的词，Value为该词所对应的拼音
     *
     * @return 包含词和对应拼音的 {@link Map}
     */
    @Override
    public Map<String, String[]> mapping() {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("解",  new String[]{"XIE"});
        return map;
    }
}
