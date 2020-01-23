package com.goat.B.B06.item11;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---16:35
 */

public interface IFile {

    //下面两个方法，相当于类图中operation方法
    void delete();

    String getName();

    /* 以上为公共行为，以下为文件夹才有的行为 */
    //创建新文件，相当于add方法
    void createNewFile(String name);

    //相当于remove方法
    void deleteFile(String name);

    //相当于GetChild方法
    IFile getIFile(int index);

}