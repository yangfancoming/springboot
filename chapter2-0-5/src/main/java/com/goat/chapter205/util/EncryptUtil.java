package com.goat.chapter205.util;

import java.security.MessageDigest;

/**
 * Created by Administrator on 2020/2/27.
 * @ Description: 生成电子签名的工具类
 * @ author  山羊来了
 * @ date 2020/2/27---10:10
 */
public class EncryptUtil {

    /**
     * 或许你完全不理解上述代码的含义，但是你只要理解所有的输入调用此方法后均会生成一个独一无二的hash值（数字签名），而这个hash值在区块链中是非常重要的。
     */
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
