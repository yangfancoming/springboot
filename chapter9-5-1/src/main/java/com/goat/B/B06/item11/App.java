package com.goat.B.B06.item11;

import org.junit.Test;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---16:37
 */
public class App {

    @Test
    public void tst(){
        IFile root = new Folder("我的电脑");
        root.createNewFile("C盘");
        root.createNewFile("D盘");
        root.createNewFile("E盘");


        IFile D = root.getIFile(1);
        D.createNewFile("project");
        D.createNewFile("电影");

        IFile project = D.getIFile(0);
        project.createNewFile("test1.java");
        project.createNewFile("test2.java");
        project.createNewFile("test3.java");

        IFile movie = D.getIFile(1);
        movie.createNewFile("致青春.avi");
        movie.createNewFile("速度与激情6.avi");

        /* 以上为当前文件系统的情况，下面我们尝试删除文件和文件夹 */
        display(null, root);
        project.delete();
        movie.getIFile(1).delete();
        display(null, root);

    }

    public static void display(String prefix,IFile iFile){
        if (prefix == null) {
            prefix = "";
        }
        System.out.println(prefix + iFile.getName());
        if(iFile instanceof Folder){
            for (int i = 0; ; i++) {
                try {
                    if (iFile.getIFile(i) != null) {
                        display(prefix + "--", iFile.getIFile(i));
                    }
                } catch (Exception e) {
                    break;
                }
            }
        }
    }

}
