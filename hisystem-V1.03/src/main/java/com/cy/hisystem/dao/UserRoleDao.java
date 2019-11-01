package com.cy.hisystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.hisystem.pojo.UserRolePojo;


/**
 * 执行用户角色表的相关操作
 *
 * @author 吴凯强
 */
@Mapper
public interface UserRoleDao {
	
	/**
	 * 新增用户角色关系
	 * @param userRolePojo 用户角色关系
	 * @return
	 */
	int insertUserRole(UserRolePojo userRolePojo);
	
	/**
	 * 根据用户id查询角色id
	 * @param userId
	 * @return
	 */
	List<String> fiadRoleIdByUserId(String userId);

}
