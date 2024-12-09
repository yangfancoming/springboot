package com.goat.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

public class DesUtils {

	private final static String DES = "DES";
	
	/**
	 * 根据键值进行加密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes("UTF-8"), key.getBytes());
		String strs = new BASE64Encoder().encode(bt);
		return strs;
	}
			
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		//生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		//从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		//创建一个密钥工厂 然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey secureKey = keyFactory.generateSecret(dks);
		
		//Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		//用密钥初始化cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);
		
		return cipher.doFinal(data);
	}

	/**
	 * 根据键值进行解密
	 * @param data
	 * @param key
	 * @return
	 * @throws Exception 
	 */
	public static String decrypt(String data,String key) throws Exception {
		if(data == null) {
			return null;
		}
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] buf = decoder.decodeBuffer(data);
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		//生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();
		//从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);
		//创建一个密钥工厂 然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey secureKey = keyFactory.generateSecret(dks);
		
		//Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);
		//用密钥初始化cipher对象
		cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);
		
		return cipher.doFinal(data);
	}

	public static void main(String[] args) throws Exception {

		String data = "123";
		String key = "yy@123456789";
		String encodeStr = encrypt(data, key);
		String decodeStr = decrypt(encodeStr, key);
		System.out.println(encodeStr);
		System.out.println(decodeStr);
	}

}
