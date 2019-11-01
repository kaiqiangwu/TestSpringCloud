package com.cy.hisystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.hisystem.pojo.MedicalRecordPojo;

/**
 * 处方表数据库操作接口
 *
 * @author 吴凯强
 */
@Mapper
public interface MedicalRecordDao {

	/**
	 * 根据处方号查询处方记录
	 * @return 处方表实体类
	 */
	MedicalRecordPojo findByPrescriptionnum(@Param("prescriptionnum") String prescriptionnum);
	
	/**
	 *  根据挂号id查询处方号
	 * @param id 挂号id
	 * @return
	 */
	MedicalRecordPojo findByregisterid(@Param("id") String id);
	
	/**
	 * 根据处方号更新取药信息
	 * @param prescriptionnum 处方号
	 * @param tollOperator 收费操作员
	 * @return 影响行数
	 */
	int updateByPrescriptionnum(@Param("takingDrugOperator") String takingDrugOperator,@Param("prescriptionnum") String prescriptionnum);
	
	
	
	/**
	 * 根据处方号更新取药信息
	 * @param prescriptionnum 处方号
	 * @param tollOperator 收费操作员
	 * @return 影响行数StringprescriptionNum
	 */
	int updateMedicalRecords(@Param("prescriptionNum") String prescriptionNum,@Param("tollDateTime") String tollDateTime,@Param("tollOperator") String tollOperator,@Param("tollFrequency") int tollFrequency);
	
}
