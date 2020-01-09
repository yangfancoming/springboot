package com.goat.B.B06.item10;

import java.util.List;

/**
 * 定义分支节点（根节点）
 */
public interface IBranch {

    /**
     * 获得分支节点信息
     * @return
     */
    public String getInfo();

    /**
     * 增加分支节点（文件夹下还可能会有文件夹）
     * @param branch
     */
    public void addBranch(IBranch branch);

    /**
     * 增加叶子节点
     * @param leaf
     */
    public void addLeaf(ILeaf leaf);

    /**
     * 获得子集
     * @return
     */
    public List getChildren();
}