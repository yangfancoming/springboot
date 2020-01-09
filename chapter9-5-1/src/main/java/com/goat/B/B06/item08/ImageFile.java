package com.goat.B.B06.item08;

/**
 * Created by Administrator on 2020/1/9.
 *
 * @ Description: 叶子节点：文件类型，就写了一种。
 * @ author  山羊来了
 * @ date 2020/1/9---9:00
 */
public class ImageFile extends AbstractFiles {

    private String name;

    public ImageFile(String name) {
        this.name=name;
    }

    @Override
    public void add(AbstractFiles af) {
        System.out.println("不支持该方法");
    }

    @Override
    public void remove(AbstractFiles af) {
        System.out.println("不支持该方法");
    }

    @Override
    public AbstractFiles get(int i) {
        System.out.println("不支持该方法");
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("开始 ImageFile 进行--"+name+"--文件杀毒");
    }

}
