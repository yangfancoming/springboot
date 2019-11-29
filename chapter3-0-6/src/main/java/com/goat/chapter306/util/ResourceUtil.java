package com.goat.chapter306.util;

import java.io.InputStream;

/**
 * Created by Administrator on 2019/11/29.
 *
 * @ Description:
 * @ author  山羊来了
 * @ date 2019/11/29---10:32
 */
public class ResourceUtil {

    private InputStream resourceLoader;

    public InputStream getResource(String path){
         resourceLoader = this.getClass().getClassLoader().getResourceAsStream(path);
        return resourceLoader;
    }


}
