package com.goat.B.B06.item03;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/7/15.
 *
 * @ Description: 文件夹类：Folder.java，该类包含对文件的增加、删除和浏览三个方法
 * @ author  山羊来了
 * @ date 2019/7/15---21:17
 */
public class Folder extends File{

    private List<File> files;

    public Folder(String name){
        super(name);
        files = new ArrayList<>();
    }

    /**
     * 浏览文件夹中的文件
     */
    @Override
    public void display() {
        for(File file : files){
            file.display();
        }
    }

    /**
     * @desc 向文件夹中添加文件
     * @param file
     * @return void
     */
    public void add(File file){
        files.add(file);
    }

    /**
     * @desc 从文件夹中删除文件
     * @param file
     * @return void
     */
    public void remove(File file){
        files.remove(file);
    }
}
