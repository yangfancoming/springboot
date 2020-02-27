package com.goat.chapter205.item01;

import com.goat.chapter205.util.BlockChainUtil;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/2/27.
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/27---10:07
 */
public class App {

    @Test
    public void test1(){
        Block firstBlock = new Block("first", "0");
        System.out.println("Hash for block 1: " + firstBlock.hash);

        Block secondBlock = new Block("second", firstBlock.hash);
        System.out.println("Hash for block 2: " + secondBlock.hash);

        Block thirdBlock = new Block("third", secondBlock.hash);
        System.out.println("Hash for block 3: " + thirdBlock.hash);
    }

    public static List<Block> blockchain = new ArrayList<>();

    //add our blocks to the blockchain ArrayList:
    public void init(){
        blockchain.add(new Block("Hi im the first block", "0"));
        // blockchain.get(blockchain.size()-1).hash  集合中最后一个元素的hash值
        blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
        blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
    }

    @Test
    public void test2(){
        init();
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println(blockchainJson);
    }

    @Test
    public void test3(){
        init();
        Boolean chainValid = BlockChainUtil.isChainValid(blockchain);
        System.out.println(chainValid);
    }
}
