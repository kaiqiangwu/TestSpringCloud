package com.cy.hisystem.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.RoleDao;
import com.cy.hisystem.dao.UserDao;
import com.cy.hisystem.dao.UserRoleDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.UserPojo;
import com.cy.hisystem.pojo.UserRolePojo;
import com.cy.hisystem.service.EmailService;
import com.cy.hisystem.service.UserService;
import com.cy.hisystem.util.DateUtil;
import com.cy.hisystem.util.MD5EncryptionUtil;
import com.cy.hisytem.pojo.vo.SignupVo;

/**
 * 用户表操作实现类
 * 
 * @author 李溢
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	EmailService emailService;

	@Autowired
	UserRoleDao userRoleDao;

	@Autowired
	RoleDao roleDao;

	/**
	 * 获取所有就诊医生信息
	 */
	@Override
	public List<UserPojo> getAllRegisterDoctor(String department, String registerType) {
		return userDao.getAllRegisterDoctor(department, registerType);
	}

	@Override
	public boolean doLoginChecking(String email, String plainPassword) {
		// 判断email是否合法
		if (email == null || "".equals(email)) {
			throw new ServiceException("请输入用户名！");
		}
		UserPojo userPojo = userDao.findUserAccountByEamil(email);
		if (userPojo == null) {
			throw new ServiceException("用户名不正确！");
		}
		Integer emailStatus = userPojo.getEmailStatus();
		if (emailStatus == 0) {
			throw new ServiceException("此用户尚未通过邮箱验证！");
		} 
		// 获取数据库加密后的密码
		String dbPassword = userPojo.getPassword();
		// 获取加密盐值
		String salt = userPojo.getSalt();
		// 根据盐值加密获取的密码
		String passwordCheck = new MD5EncryptionUtil().passwordCheck(plainPassword, salt);
		// 比对密码
		if (!passwordCheck.equals(dbPassword)) {
			throw new ServiceException("输入的密码出错！");
		}
		return true;
	}

	/**
	 * 注册用户
	 * 
	 * @param signupVo 用户注册信息
	 */
	@Override
	public void insertUser(SignupVo signupVo) {

		// 邮箱的正则表达式
		String regexEmail = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

		// 输入的邮箱号
		String email = signupVo.getEmail();
		// 邮箱格式校验
		if (!Pattern.matches(regexEmail, email)) {
			throw new ServiceException("请输入正确的邮箱号");
		}
		// 校验账号是否存在
		int count = userDao.selectEmailCount(email);
		if (count > 1) {
			throw new ServiceException("账号已存在");
		}
		// 生成用户id
		String id = UUID.randomUUID().toString();
		// 原始密码
		String plainPassword = signupVo.getPassword();
		signupVo.setPlainPassword(plainPassword);
		// 加密密码
		MD5EncryptionUtil md5 = new MD5EncryptionUtil();
		Map<String, String> map = md5.EncryptionPlainPassword(plainPassword);
		String salt = map.get("salt");
		String password = map.get("password");
		// 创建时间
		String createDatetime = DateUtil.getCurrentTimeString();
		// 激活码
		String validateCode = UUID.randomUUID().toString();

		signupVo.setCreateDatetime(createDatetime);
		signupVo.setId(id);
		signupVo.setSalt(salt);
		signupVo.setPassword(password);
		signupVo.setValidateCode(validateCode);

		int row = userDao.insertUserSignup(signupVo);
		if (row == 0) {
			throw new ServiceException("注册失败");
		}

		emailService.setVariable("email", email);
		emailService.setVariable("validateCode", validateCode);

		try {
			emailService.sendEmail(email, "激活账号", "email/email");
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new ServiceException("邮件发送失败");
		}

		String roleId = roleDao.findRoleIdByRoleValue(signupVo.getRoleValue());

		/*
		 * id id uid 用户id role_id 角色id desciption 说明（账号#用户名） create_datetime 创建时间
		 */

		UserRolePojo userRolePojo = new UserRolePojo();

		String userRoleId = UUID.randomUUID().toString();
		String desciption = email + "#" + signupVo.getUsername();
		userRolePojo.setCreateDatetime(createDatetime);
		userRolePojo.setDesciption(desciption);
		userRolePojo.setId(userRoleId);
		userRolePojo.setUid(id);
		userRolePojo.setRoleId(roleId);

		row = userRoleDao.insertUserRole(userRolePojo);
		if (row == 0) {
			throw new ServiceException("注册失败");
		}
	}

	/**
	 * 激活账号
	 * 
	 * @param email
	 * @param validateCode
	 */
	@Override
	public void activation(String email, String validateCode) {

		String myValidateCode = userDao.findValidateCodeByEmail(email);
		System.out.println(validateCode);
		System.out.println(myValidateCode);
		if (myValidateCode == null || !myValidateCode.equals(validateCode)) {
			throw new ServiceException("激活失败");
		}

		int rows = userDao.updateEmailStatusByEmail(email);

		if (rows == 0) {
			throw new ServiceException("激活失败");
		}

	}

}
