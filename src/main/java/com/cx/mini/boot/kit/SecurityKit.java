package com.cx.mini.boot.kit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * 用来生成散列码
 */
public class SecurityKit {
	
	// 返回将参数加密后的字符串
	public static String sha(String str) {
		
		StringBuffer sb = new StringBuffer();
		
		try {
			// 以参数指定的形式生成MessageDigest实例
			MessageDigest md = MessageDigest.getInstance("sha");
			
			// 将数据更新
			md.update(str.getBytes());
			
			// 执行哈希计算, 得到计算后的字节数组
			byte[] message = md.digest();
			
			// 将得到的字节数组转为16进制的形式
			for (byte b : message) {
				// 格式化字节数组中的每个字节, 将其转换为16进制表示
				String bx16 = String.format("%02x", b);
				sb.append(bx16);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
