package com.goat;


import com.goat.utils.LicenseMake;
import org.testng.annotations.Test;


/**
     * @Description:  需先启动 chapter0-0-0  项目  后 方可进行测试
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/22
*/

public class TestNG {

    @Test
    public void testG1et() throws Exception {
        String path = Test.class.getResource("/").getPath();
        System.out.println("path="+path);

    }

    public static void main(String[] args) {
        LicenseMake clicense=new LicenseMake("licenseMakeConf.properties");
        clicense.create();
    }

    @Test
    public void testGet() throws Exception {
        LicenseMake clicense=new LicenseMake("licenseMakeConf.properties");
        clicense.create();
    }

}
