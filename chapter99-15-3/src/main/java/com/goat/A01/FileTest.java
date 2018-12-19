package com.goat.A01;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


/**
 * Created by 64274 on 2018/6/25.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/6/25---17:14
 *
 * File 构造方法：

File(String pathname)  通过一个路径 得到File对象
File(String parent, String child)  根据一个目录和一个子文件 得到File 对象
File(File parent, String child)  根据一个父File对象 和一个子文件 得到File 对象

创建功能：
boolean createNewFile()    创建文件   如果不存在 则创建该文件  如果存在就不创建了  返回是否创建成功
boolean mkdir()            创建文件夹 如果不存在 则创建该目录  如果存在就不创建了  返回是否创建成功
boolean mkdirs()           创建文件夹 如果父级目录不存在 则强制创建
删除功能：
boolean delete()           删除文件或文件夹 如果不存在 则返回false  如果存在就删除   返回是否创建成功

 */
public class FileTest {


    File file = new File("."); //以当前路径创建一个file对象

    @Test
    public void test(){
        //直接获取文件名，输出一个.
        System.out.println(file.getName());
        //输出相对路径的父路径，可能出错，null,使用相对路径的File获取父路径可能引起错误
        System.out.println(file.getParent());
    }
    @Test
    public void test2(){
        //获取绝对路径
        System.out.println(file.getAbsoluteFile());
        //获取上一级路径
        System.out.println(file.getAbsoluteFile().getParent());
    }
    @Test
    public void createTempFile() throws IOException {
        //在当前路径下创建一个临时文件
        File tmpFile = File.createTempFile("aaa", ".txt",file);
        //指定jvm退出时删除该文件 (函数运行结束后 该文件将被删除)
        tmpFile.deleteOnExit();
    }

    @Test
    public void createNewFile() throws IOException {
        //以系统时间为文件名创建文件
        File newFile= new File(System.currentTimeMillis()+"");
        System.out.println("newFile文件是否存在： "+ newFile.exists()); // false
        //以newFile对象创建一个文件
        newFile.createNewFile();
        //以newFile对象创建一个目录，因为newFile已经存在，返回false 无法创建
        System.out.println(newFile.mkdir());
    }
    @Test
    public void fileList() {
        //列出当前路径下所有文件和路径
        String [] fileList = file.list();
        System.out.println("========当前路径下所有文件和路径========");
        for(String fileName:fileList)
            System.out.println(fileName);
    }
    @Test
    public void listRoots() {
        //listRoot()静态方法，列出所有磁盘根路径
        File [] roots = File.listRoots();
        System.out.println("==========系统所有跟路径如下");
        for(File root:roots)
            System.out.println(root);
    }

    // File.list()方法参数 FilenameFilter 示例
    @Test
    public void list() {
        FilenameFilter();
    }

    public static void FilenameFilter() {
        File  file = new File(".");
        //使用lambda表达式(目标类型为FilenameFilter) 实现文件过滤器,实现FilenameFilter中accept()方法
        //如果文件以java结尾或者文件中对应一个路径，则返回true,
        String [] nameList = file.list((dir,name)->name.endsWith(".java")|| new File(name).isDirectory());
        for(String name:nameList){
            System.out.println(name);
        }
    }
}
