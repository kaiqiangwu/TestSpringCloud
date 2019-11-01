package com.cy.hisystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 执行角色表的相关操作
 *
 * @author 吴凯强
 */
@Mapper
public interface RoleDao {

	/**
	 * 根据角色编号查询角色id
	 * @param roleValue
	 * @return
	 */
	public String findRoleIdByRoleValue(Integer roleValue); 
	
	/**
	 * 根据角色id查询角色名
	 * @param roleId
	 * @return
	 */
	List<String> findRoleByRoleId(List<String> roleIds);
	
}
