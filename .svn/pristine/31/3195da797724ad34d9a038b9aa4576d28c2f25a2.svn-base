package com.cy.hisystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.hisystem.pojo.PatientInforRspPojo;

/**
 * @author 张孙传
 * 门诊方法的dao层
 */
@Mapper
public interface OutpatientServiceDao {
	/**
	 * 根据cardId查询病人信息
	 * @param cardId
	 * @return
	 */
	PatientInforRspPojo findPatientInforRsp(
			@Param("cardId")String cardId);
	
	
	/**
	 * 在门诊页面获取婚姻,职业,个人史,既往史,家族史
	 * 存入PatientInforRspPojo对象中,往数据库存储
	 * @param patient
	 */
	int changePatientInfor(
			@Param("career")String career,
			@Param("familyHistory")String familyHistory,
			@Param("maritalStatus")String maritalStatus,
			@Param("pastHistory")String pastHistory,
			@Param("personalHistory")String personalHistory);
	
	
	/**
	 * 根据患者表id查询病人信息
	 * @param id 患者表id
	 * @return 患者表实体类
	 */
	PatientInforRspPojo findPatientInforById(String id);
	
	/**
	 * 查询检查结果的方法
	 * @return
	 */
	int findMedicalExamination();
	
	/**
	 * 
	 */
	void addMedicalRecord();
	/**
	 * 
	 */
	void processLater();
	/**
	 * 
	 */
	void selectTemplate();
	/**
	 * 
	 */
	void addDrugs();
	/**
	 * 在js中回显数据到html
	 */
	void restorePatientInfor();
}
