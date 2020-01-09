package com.goat.B.B06.item10;

/**
 * 叶子节点（文件）
 */
public class File implements ILeaf {

    private String name;

    public File(String name){
        this.name = name;
    }

    /**
     * 获得叶子节点的信息
     */
    @Override
    public String getInfo() {
        return "名称：" + name;
    }
}