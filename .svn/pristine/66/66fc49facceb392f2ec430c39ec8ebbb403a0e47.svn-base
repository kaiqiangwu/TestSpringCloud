package com.cy.hisystem.service;

import java.util.List;

import com.cy.hisystem.pojo.UserPojo;
import com.cy.hisytem.pojo.vo.SignupVo;

/**
 * 用户表相关操作接口
 * 
 * @author 李溢 黄德傲
 *
 */
public interface UserService {
	/**
	 * 从User表中获取用户中所有的挂号医生信息
	 * 
	 * @return
	 */
	List<UserPojo> getAllRegisterDoctor(String department, String registerType);

	/**
	 * 校验用户的登录名与密码
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	boolean doLoginChecking(String email, String password);

	/**
	 * 注册用户
	 * 
	 * @param signupVo 用户注册信息
	 */
	void insertUser(SignupVo signupVo);

	/**
	 * 激活账号
	 * 
	 * @param email
	 * @param validateCode
	 */
	void activation(String email, String validateCode);
}
