package com.cy.hisystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cy.hisystem.dao.MedicalRecordDao;
import com.cy.hisystem.dao.OutpatientServiceDao;
import com.cy.hisystem.dao.RegisterDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.MedicalRecordPojo;
import com.cy.hisystem.pojo.PatientInforRspPojo;
import com.cy.hisystem.pojo.RegisterPojo;
import com.cy.hisystem.service.TollService;
import com.cy.hisystem.util.DateUtil;
import com.cy.hisytem.pojo.vo.MedicalRecordRegisterVo;
@Service
public class ToolServiceImple implements TollService{

	@Autowired
	private RegisterDao registerdao;
	
	@Autowired
	private MedicalRecordDao medicalRecordao;
	
	@Autowired
	private OutpatientServiceDao outpatientdao;
	
	@Override
	public List<MedicalRecordRegisterVo> getlistRegistinfo(String cardId, String tollStatus) throws IllegalAccessException {
		if("".equals(cardId) && "".equals(tollStatus)) {
			throw new ServiceException("参数值非法，不可为空");
		}
		PatientInforRspPojo p = outpatientdao.findPatientInforRsp(cardId);
		List<MedicalRecordRegisterVo> listvo = new LinkedList<>();
		if(null!=p) {
			String patientId = p.getId();
			List<RegisterPojo> listrRegisters = registerdao.getRegisterInfos(patientId, tollStatus);
			if(null!=listrRegisters && listrRegisters.size()!=0){
				for(RegisterPojo pojo : listrRegisters) {
					MedicalRecordRegisterVo m = new MedicalRecordRegisterVo();
					//1 .获取挂号id
					String id = pojo.getId();
					//2 根据挂号id获取对应处方对象
					MedicalRecordPojo e = medicalRecordao.findByregisterid(id);
					//3.获取处方对象
					if(null!=e) {
						String prescriptionnum = e.getPrescriptionnum();
						//4 保存挂号处方视图对象
						m.setDepartment(pojo.getDepartment());
						m.setRegisterType(pojo.getRegisterType());
						m.setDoctorName(pojo.getDoctor());
						m.setPrescriptionNum(prescriptionnum);
						listvo.add(m);
					}
				}
			}
		}
		return listvo;
	}

	@Override
	@Transactional
	public void SaveMedicalRecordPojo(MedicalRecordPojo reqVO) {
		//1.判断参数是否为空
		String prescriptionNum = reqVO.getPrescriptionnum();
		if("".equals(prescriptionNum)) {
			throw new ServiceException("参数值非法，不可为空");
		}
		
		//2.根据处方号获取处方表中的 挂号id
		MedicalRecordPojo medicalRecordPojo = medicalRecordao.findByPrescriptionnum(prescriptionNum);
		SimpleDateFormat sdfDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int tollFrequency = medicalRecordPojo.getTollFrequency();
		medicalRecordao.updateMedicalRecords(prescriptionNum,sdfDateFormat.format(new Date()),"", tollFrequency+1);
		
		//3.根据挂号id获取挂号信息
		RegisterPojo registerPojo = registerdao.findById(medicalRecordPojo.getRegisterId());
			if(null!=registerPojo) {
				registerPojo.setChargeStatus(1);
				registerdao.updateRegisterbyid(registerPojo);
			}
	}

}
