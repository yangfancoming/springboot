package com.goat;


import com.goat.utils.BarCodeUtil;
import com.google.zxing.BarcodeFormat;
import org.testng.annotations.Test;


/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param:
     * @Return: 
     * @Date:   2018/12/5
*/

public class BarTestNG  {

    @Test
    public void EAN_13(){
        String imgPath = "src/222.png";  // 条形码 生成路径
        String contents = "6923450657713"; // 益达无糖口香糖的条形码
        int width = 105, height = 50;
        BarCodeUtil.encode(contents,BarcodeFormat.EAN_13, width, height, imgPath);
    }

    @Test
    public void CODE_128(){
        String imgPath = "src/333.png";  // 条形码 生成路径
        String contents = "X000121000220010D"; // upn
        int width = 105, height = 50;
        BarCodeUtil.encode(contents,BarcodeFormat.CODE_128, width, height, imgPath);
    }


    @Test
    public void decode(){
        String imgPath = "src/333.png";  // 条形码 生成路径
        String result = BarCodeUtil.decode(imgPath);
        System.out.println(result);
    }

}
