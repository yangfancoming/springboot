package com.goat.chapter205.item01;


import com.goat.chapter205.util.EncryptUtil;

import java.util.Date;

/**
 * 区块
 */
public class Block {

    // 当前区块的hash
    public String hash;

    // 上一个区块的hash
    public String previousHash;

    // 当前区块的数据
    private String data;

    // 时间戳
    private long timeStamp;

    private int nonce;

    public Block(String hash, String previousHash, String data) {
        this.hash = hash;
        this.previousHash = previousHash;
        this.data = data;
    }

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.data = data;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    /**
     * 其主要的目的就是计算hash值，我们计算的hash值应该包括区块中所有我们不希望被恶意篡改的数据，
     * 在我们上面所列的Block类中就一定包括previousHash，data和timeStamp
    */
    public String calculateHash() {
        return EncryptUtil.applySha256(previousHash + timeStamp + nonce + data);
    }

    /**
     * difficulty难度，低的难度比如1和2，普通的电脑基本都可以马上计算出来，我的建议是在4-6之间进行测试，
     * 普通电脑大概会花费3秒时间，在莱特币中难度大概围绕在442592左右，
     * 而在比特币中每一次挖矿都要求大概在10分钟左右，
     * 当然根据所有网络中的计算能力，难度也会不断的进行修改。
    */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); //Create a string with difficulty * "0"
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
        System.out.println("Block Mined!!! : " + hash);
    }
}
