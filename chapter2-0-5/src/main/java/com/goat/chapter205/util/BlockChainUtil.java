package com.goat.chapter205.util;

import com.goat.chapter205.item01.Block;

import java.util.List;

/**
 * Created by Administrator on 2020/2/27.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/27---10:37
 */
public class BlockChainUtil {


    /**
     *
     * 目的是循环区块链中的所有区块并且比较hash值，这个方法用来检查hash值是否是于计算出来的hash值相等，
     * 同时previousHash值是否和前一个区块的hash值相等。或许你会产生如下的疑问，
     * 我们就在一个主函数中创建区块链中的区块，所以不存在被修改的可能性，
     * 但是你要注意的是，区块链中的一个核心概念就是去中心化，每一个区块可能是在网络中的某一个节点中产生的，
     * 所以很有可能某个节点把自己节点中的数据修改了，那么根据上述的理论数据改变会导致整个区块链的破裂，也就是区块链就无效了。
    */
    public static Boolean isChainValid(List<Block> blockChain) {
        Block currentBlock;
        Block previousBlock;

        //loop through blockchain to check hashes:
        for(int i=1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);
            //compare registered hash and calculated hash:
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //compare previous hash and registered previous hash
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }


}
