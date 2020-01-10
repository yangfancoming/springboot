package com.goat.B.B06.item11;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---16:35
 */
//文件
public class File implements IFile{

    private String name;

    private IFile folder;

    public File(String name,IFile folder) {
        this.name = name;
        this.folder = folder;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void delete() {
        folder.deleteFile(name);
        System.out.println("---删除[" + name + "]---");
    }

    //文件不支持创建新文件
    @Override
    public void createNewFile(String name) {
        throw new UnsupportedOperationException();
    }

    //文件不支持删除文件
    @Override
    public void deleteFile(String name) {
        throw new UnsupportedOperationException();
    }

    //文件不支持获取下面的文件列表
    @Override
    public IFile getIFile(int index) {
        throw new UnsupportedOperationException();
    }

}