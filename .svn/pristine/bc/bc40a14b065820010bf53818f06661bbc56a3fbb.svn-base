package com.cy.hisystem.service;

import com.cy.hisytem.pojo.vo.MedicalRecordRegisterVo;

/**
 * 药房取药业务层接口
 *
 * @author 吴凯强
 */
public interface MedicalRecordService {
	
	/**
	 * 根据处方号查询门诊处方笺信息
	 * @param prescriptionnum:处方号
	 * @return MedicalRecordPojo
	 */
	MedicalRecordRegisterVo findByPrescriptionnum(String prescriptionnum);
	
	/**
	 * 根据处方号更新取药信息
	 * @param prescriptionnum 处方号
	 * @param tollOperator 收费操作员
	 */
	void updateByPrescriptionnum(String takingDrugOperator,String prescriptionnum);
}
