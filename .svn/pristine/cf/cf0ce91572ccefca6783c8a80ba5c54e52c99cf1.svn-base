package com.cy.hisystem.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
/**
 * 	密码加密与校验工具类
 * @author 黄德傲
 *
 */
public class MD5EncryptionUtil {
	/**盐值*/
	private String salt;
	/**加密后的密码*/
	private String password;
	/**加密次数*/
	private Integer hashIterations = 1;
	
	/**
	 * 	使用MD5方式加密原始密码
	 * @param plainPassword	未加密的密码
	 * @return	盐值和加密后的明文
	 */
	public Map<String,String> EncryptionPlainPassword(String plainPassword){
		//获取随机盐值
		this.salt = UUID.randomUUID().toString();
		//加密传入的密码
		this.password = MD5ExtractedMethod(plainPassword);
		//将盐值和加密后的密码封装进map中
		Map<String,String> map = new HashMap<>();
		map.put("salt", this.salt);
		map.put("password", this.password);
		return map;
	}

	/**
	 * 	加密指定盐值的原始密码
	 * @param plainPassword
	 * @return	加密后的密码明文
	 */
	private String MD5ExtractedMethod(String plainPassword) {
		return new SimpleHash("MD5", plainPassword, this.salt, hashIterations).toHex();
	}
	
	public String passwordCheck(String plainPassword,String salt) {
		this.salt = salt;
		this.password = MD5ExtractedMethod(plainPassword);
		return this.password;
	}
}
