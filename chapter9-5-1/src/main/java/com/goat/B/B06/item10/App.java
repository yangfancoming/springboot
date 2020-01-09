package com.goat.B.B06.item10;

import org.junit.Test;
import java.util.List;

/**
 * Created by Administrator on 2020/1/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/9---9:22
 */
public class App {

    @Test
    public void test(){
        // 定义根节点
        IBranch root = new Folder("root");

        // 定义二级节点的文件夹
        IBranch imageFolder = new Folder("image-folder");
        IBranch documentFolder = new Folder("document-folder");
        //定义二级节点的文件
        ILeaf systemFile = new File("system-file.bat");

        // 定义三级节点的文件夹
        IBranch pngFolder = new Folder("png-folder");
        IBranch gifFolder = new Folder("gif-folder");
        // 定义三级节点的文件
        ILeaf testHtml = new File("test.html");
        ILeaf testJS = new File("test.js");

        // 定义四级节点的文件，两个png文件
        ILeaf test1png = new File("test1.png");
        ILeaf test2png = new File("test2.png");
        // 定义四级节点的文件3个gif文件
        ILeaf my1gif = new File("my1.gif");
        ILeaf my2gif = new File("my2.gif");
        ILeaf my3gif = new File("my3.gif");

        // 填充一级文件夹
        root.addBranch(imageFolder);
        root.addBranch(documentFolder);
        root.addLeaf(systemFile);
        // 填充二级图片文件夹
        imageFolder.addBranch(pngFolder);
        imageFolder.addBranch(gifFolder);
        // 填充二级文档文件夹
        documentFolder.addLeaf(testHtml);
        documentFolder.addLeaf(testJS);

        // 填充三级png图片文件夹
        pngFolder.addLeaf(test1png);
        pngFolder.addLeaf(test2png);
        //填充三级gif图片文件夹
        gifFolder.addLeaf(my1gif);
        gifFolder.addLeaf(my2gif);
        gifFolder.addLeaf(my3gif);

        System.out.println(root.getInfo());

        // 打印出来
        getChildrenInfo(root.getChildren());
    }


    /**
     * 递归遍历文件
     * @param arrayList
     */
    private static void getChildrenInfo(List arrayList){

        int length = arrayList.size();

        for(int m = 0;m<length;m++){
            Object item = arrayList.get(m);
            //如果是叶子节点就直接打印出来名称
            if(item instanceof ILeaf){
                System.out.println(((ILeaf) item).getInfo());
            }else {
                //如果是分支节点就先打印分支节点的名称，再递归遍历子节点
                System.out.println(((IBranch)item).getInfo());
                getChildrenInfo(((IBranch)item).getChildren());
            }

        }

    }
}
