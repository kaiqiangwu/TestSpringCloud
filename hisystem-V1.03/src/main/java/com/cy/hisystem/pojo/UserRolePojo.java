package com.cy.hisystem.pojo;

import java.io.Serializable;

/**
 * 封装用户角色表信息
 *
 * @author 吴凯强
 */
public class UserRolePojo implements Serializable {
	
	private static final long serialVersionUID = 5591699503042962608L;

	/** id */
	private String id;
	
	/** 用户id */
	private String  uid;
	
	/** 角色id */
	private String roleId;
	
	/**  用户信息 */
	private String desciption;
	
	/** 创建时间 */
	private String createDatetime;
	
	/** 角色状态 */
	private Integer role_status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public Integer getRole_status() {
		return role_status;
	}

	public void setRole_status(Integer role_status) {
		this.role_status = role_status;
	}

	@Override
	public String toString() {
		return "UserRolePojo [id=" + id + ", uid=" + uid + ", roleId=" + roleId + ", desciption=" + desciption
				+ ", createDatetime=" + createDatetime + ", role_status=" + role_status + "]";
	}
	
	


}
