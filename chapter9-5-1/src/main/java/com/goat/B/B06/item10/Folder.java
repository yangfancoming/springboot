package com.goat.B.B06.item10;

/**
 * Created by Administrator on 2020/1/9.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/9---9:20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 分支节点（文件夹）
 */
public class Folder implements IBranch{

    /**
     * 节点名称
     */
    private String name;

    /**
     * 子集
     */
    private List children = new ArrayList();

    public Folder(String name){
        this.name = name;
    }

    /**
     * 获得分支节点信息
     */
    @Override
    public String getInfo() {
        return "名称:" + name;
    }

    /**
     * 增加分支节点（文件夹下还可能会有文件夹）
     * @param branch
     */
    @Override
    public void addBranch(IBranch branch) {
        children.add(branch);
    }

    /**
     * 增加叶子节点
     */
    @Override
    public void addLeaf(ILeaf leaf) {
        children.add(leaf);
    }

    /**
     * 获得子集

     */
    @Override
    public List getChildren() {
        return children;
    }
}