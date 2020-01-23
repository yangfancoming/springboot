package com.goat.B.B06.item11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---16:36
 */
//文件夹
public class Folder implements IFile{

    private String name;
    private IFile folder;
    private List<IFile> files;

    public Folder(String name) {
        this(name, null);
    }

    public Folder(String name,IFile folder) {
        this.name = name;
        this.folder = folder;
        files = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    //与File的删除方法不同，先删除下面的文件以及文件夹后再删除自己
    @Override
    public void delete() {
        List<IFile> copy = new ArrayList<>(files);
        System.out.println("------------删除子文件-------------");
        for (IFile file : copy) {
            file.delete();
        }
        System.out.println("----------删除子文件结束-------------");
        if (folder != null) {
            folder.deleteFile(name);
        }
        System.out.println("---删除[" + name + "]---");
    }

    @Override
    public void createNewFile(String name) {
        if (name.contains(".")) {
            files.add(new File(name,this));
        }else {
            files.add(new Folder(name,this));
        }
    }

    @Override
    public void deleteFile(String name) {
        for (IFile file : files) {
            if (file.getName().equals(name)) {
                files.remove(file);
                break;
            }
        }
    }

    @Override
    public IFile getIFile(int index) {
        return files.get(index);
    }

}