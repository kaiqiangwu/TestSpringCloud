package com.cy.hisystem.service.impl;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.MedicalRecordDao;
import com.cy.hisystem.dao.OutpatientServiceDao;
import com.cy.hisystem.dao.RegisterDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.MedicalRecordPojo;
import com.cy.hisystem.pojo.PatientInforRspPojo;
import com.cy.hisystem.pojo.RegisterPojo;
import com.cy.hisystem.service.MedicalRecordService;
import com.cy.hisystem.util.DateUtil;
import com.cy.hisytem.pojo.vo.MedicalRecordRegisterVo;

/**
 * 药房取药业务层实现类,处理处方取药相关业务
 *
 * @author 吴凯强
 */
@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

	@Autowired
	MedicalRecordDao medicalRecordDao;
	
	@Autowired
	RegisterDao registerDao;
	
	@Autowired
	OutpatientServiceDao outpatientServiceDao;
	
	/**
	 * 根据处方号查询门诊处方笺信息
	 * @param prescriptionnum:处方号
	 * @return MedicalRecordPojo
	 */
	@Override
	public MedicalRecordRegisterVo findByPrescriptionnum(String prescriptionnum) {
		// 数据校验
		if(prescriptionnum == null || "".equals(prescriptionnum)) {
			throw new ServiceException("处方号不能为空");
		}
		MedicalRecordPojo medicalRecordPojo = medicalRecordDao.findByPrescriptionnum(prescriptionnum);
		if (medicalRecordPojo == null) {
			throw new ServiceException("找不到处方记录"); 
		}
		// 根据挂号id查询挂号记录
		RegisterPojo registerPojo = registerDao.findById(medicalRecordPojo.getRegisterId());
	
		// 根据患者id查询患者信息
		PatientInforRspPojo patient = outpatientServiceDao.findPatientInforById(registerPojo.getPatientId());
		
		String birthday = patient.getBirthday();
		Integer age;
		try {
			age = DateUtil.getAge(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServiceException("传入的生日日期格式不是yyyy-MM-dd");
		}
		
		// 将信息封装到门诊处方笺中
		MedicalRecordRegisterVo medicalRecordRegister = new MedicalRecordRegisterVo();
		medicalRecordRegister.setMedicalRecord(medicalRecordPojo);
		medicalRecordRegister.setDepartment(registerPojo.getDepartment());
		medicalRecordRegister.setDoctorName(registerPojo.getDoctor());
		medicalRecordRegister.setName(patient.getName());
		medicalRecordRegister.setNationality(patient.getNationality());
		medicalRecordRegister.setRegisterType(registerPojo.getRegisterType());
		medicalRecordRegister.setSex(patient.getSex());
		medicalRecordRegister.setAge(age.toString());
		medicalRecordRegister.setTreatmentPrice(registerPojo.getTreatmentPrice());
		
		return medicalRecordRegister;
	}

	/**
	 * 根据处方号更新取药信息
	 * @param prescriptionnum 处方号
	 * @param tollOperator 收费操作员
	 */
	@Override
	public void updateByPrescriptionnum(String takingDrugOperator, String prescriptionnum) {
		// 参数校验
		if(prescriptionnum == null || "".equals(prescriptionnum)) {
			throw new ServiceException("处方号不能为空");
		}
		if(prescriptionnum == null || "".equals(prescriptionnum)) {
			throw new ServiceException("处方号不能为空");
		}
		
		// 更新处方表
		int rows = medicalRecordDao.updateByPrescriptionnum(takingDrugOperator, prescriptionnum);
		
		if(rows == 0) {
			throw new ServiceException("取药失败，请重试");
		}
		
		
	}

}
