//package com.goat.concurrency.queue.linkedblockingqueue.example00;
//
//import javax.swing.*;
//import java.util.Random;
//
///**
// * Created by 64274 on 2019/4/29.
// *
// * @ Description: TODO
// * @ author  山羊来了
// * @ date 2019/4/29---17:31
// */
//public class Producer extends App implements Runnable {
//
//    private JTextArea producerTextArea;
//    private JTextArea storageTextArea;
//
//    public Producer(JTextArea producerTextArea, JTextArea storageTextArea) {
//        this.producerTextArea = producerTextArea;
//        this.storageTextArea = storageTextArea;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < size; i++) {// size是域变量，表示添加商品的次数
//            int b = new Random().nextInt(255); // 生成一个随机数
//            String text = producerTextArea.getText();// 获得生产者文本域信息
//            producerTextArea.setText(text + "生产商品：" + b + "\n");// 更新文本域信息
//            try {
//                queue.put(b);// 向队列中添加元素
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String storage = storageTextArea.getText();// 获得仓库文本域信息
//            storageTextArea.setText(storage + "仓库中还有" + queue.size() + "个商品\n");
//            try {
//                Thread.sleep(100);// 休眠0.1秒实现动态效果
//            } catch (InterruptedException ex) {
//            }
//        }
//    }
//}
