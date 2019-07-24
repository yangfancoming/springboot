package com.goat.xml.base;

import java.io.File;

/**
 * Created by 64274 on 2019/7/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/5---19:03
 */
public class MyBase {

    protected static final String path = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter4-4-0\\src\\main\\java\\com\\goat\\xml\\xmldemo\\students.xml";

    protected static final File file = new File(path);


    public static File getFile() {
        return file;
    }
}
