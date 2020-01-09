package com.goat.B.B06.item08;

import org.junit.Test;

/**
 * Created by Administrator on 2020/1/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/9---9:02
 */
public class App {

    @Test
    public void test(){
        //创建一个文件类型
        AbstractFiles f1 = new Folder("主文件夹");
        //创建文件
        AbstractFiles file1= new ImageFile("孙悟空.png");
        AbstractFiles file2= new ImageFile("龙珠.jpg");
        AbstractFiles file3= new ImageFile("帅哥威.gif");
        f1.add(file1);
        f1.add(file2);
        f1.add(file3);
        f1.killVirus();
        file1.killVirus();
    }
}
