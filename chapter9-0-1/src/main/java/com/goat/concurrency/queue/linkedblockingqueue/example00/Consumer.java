//package com.goat.concurrency.queue.linkedblockingqueue.example00;
//
//import javax.swing.*;
//
///**
// * Created by 64274 on 2019/4/29.
// *
// * @ Description: TODO
// * @ author  山羊来了
// * @ date 2019/4/29---17:34
// */
//public class Consumer extends App implements Runnable {
//
//    private JTextArea consumerTextArea;
//    private JTextArea storageTextArea;
//
//    public Consumer(JTextArea consumerTextArea, JTextArea storageTextArea) {
//        this.consumerTextArea = consumerTextArea;
//        this.storageTextArea = storageTextArea;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < size; i++) {
//            int b = 0;
//            try {
//                b = queue.take();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            String text = consumerTextArea.getText();
//            consumerTextArea.setText(text + "消费商品：" + b + "\n");
//            String storage = storageTextArea.getText();
//            storageTextArea.setText(storage + "仓库中还有" + queue.size() + "个商品\n");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }
//
//}
