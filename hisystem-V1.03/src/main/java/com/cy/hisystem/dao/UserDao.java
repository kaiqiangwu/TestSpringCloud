package com.cy.hisystem.dao;
/**
 * 用户信息操作接口
 * @author 李溢 肖家睿
 *
 */

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.hisystem.pojo.UserPojo;
import com.cy.hisytem.pojo.vo.SignupVo; 
@Mapper
public interface UserDao {
    /**
     * 从User表中获取用户中所有的挂号医生信息
     * @return
     */
    List<UserPojo> getAllRegisterDoctor(
            @Param("department") String department,
            @Param("registerType") String registerType);
    
    /**
     * 	通过email找到相应地用户账户信息
     * @param email	传入的email
     * @return	返回封装好的用户信息
     */
    UserPojo findUserAccountByEamil(String email);
    
	/**
	 * 根据注册信息添加用户表记录
	 * @param signup 注册信息
	 * @return 影响行数
	 */
	public int insertUserSignup(SignupVo signup);
	
	/**
	 * 根据email查找验证码
	 * @param email
	 * @return
	 */
	String findValidateCodeByEmail(String email);
	
	/**
	 * 根据email更新账号状态，激活账号
	 * @param email
	 * @return
	 */
	int updateEmailStatusByEmail(String email);
	
	/**
	 * 查询过账号是否存在
	 * @param email
	 * @return
	 */
	int selectEmailCount(String email);

	
	/**
	 * 根据email查询用户id
	 * @param email
	 * @return
	 */
	String findIdByEmail(String email);
	
	/**
	 * 个人中心,用户信心查询
	 * @return
	 */
	List<UserPojo> findUserObjects();
	
	/**
	 * 个人中心,修改用户信息
	 * @return
	 */
	int changeUserInfo(UserPojo userPojo);
}
