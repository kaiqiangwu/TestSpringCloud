package com.cy.hisystem.service.impl;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.OutpatientServiceDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.MedicalRecordPojo;
import com.cy.hisystem.pojo.PatientInforRspPojo;
import com.cy.hisystem.service.OutpatientServiceService;

/**
 * @author 张孙传 实现类
 */
@Service
public class OutpatientServiceImpl implements OutpatientServiceService {

	@Autowired
	private OutpatientServiceDao outpatientServiceDao;

	/**
	 * 根据就诊卡id,查询 病人信息
	 */
	
	@Override
	public PatientInforRspPojo findPatientInforRsp(
			String cardId) {
		if (cardId == null) {
			throw new ServiceException("请输入你的就诊卡号");
		}
		PatientInforRspPojo PatientInforRsp = 
				outpatientServiceDao.findPatientInforRsp(cardId);
		if (PatientInforRsp == null) {
			throw new ServiceException("病人信息不存在");
		}
		return PatientInforRsp;
	}




	/**
	 * 修改病人信息
	 */
	
	@Override
	public int changePatientInfor(
			@Param("career") String career, 
			@Param("familyHistory") String familyHistory,
			@Param("maritalStatus") String maritalStatus, 
			@Param("pastHistory") String pastHistory,
			@Param("personalHistory") String personalHistory) {
		int rows = 
				outpatientServiceDao.changePatientInfor(
				career, familyHistory, maritalStatus, pastHistory,
				personalHistory);
		if (rows == 0) {
			throw new ServiceException("修改失败");
		}
		return rows;
	}

	/**
	 * 查询检查结果的方法
	 */
	
	@Override
	public int findMedicalExamination() {
		int rows = outpatientServiceDao.findMedicalExamination();
		if (rows == 0) {
			throw new ServiceException("没有此查询结果");
		}
		return rows;
	}



	@Override
	public int addMedicalRecord(MedicalRecordPojo medicalRecordPojo) {
		//将婚姻,职业...等信息修改或存入数据库
		return 0;
	}


}
