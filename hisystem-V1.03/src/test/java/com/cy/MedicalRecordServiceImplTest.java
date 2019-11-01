package com.cy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.hisystem.dao.MedicalRecordDao;
import com.cy.hisystem.dao.OutpatientServiceDao;
import com.cy.hisystem.service.impl.MedicalRecordServiceImpl;
import com.cy.hisytem.pojo.vo.MedicalRecordRegisterVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicalRecordServiceImplTest {

	@Autowired
	MedicalRecordServiceImpl medicalRecordServiceImpl;
	@Autowired
	OutpatientServiceDao outpatientServiceDao;
	@Autowired
	MedicalRecordDao medicalRecordDao;
	
	@Test
	public void testFindByPrescriptionnum() {
		MedicalRecordRegisterVo medicalRecordRegisterVo = medicalRecordServiceImpl.findByPrescriptionnum("1559747520517");
		System.out.println(medicalRecordRegisterVo);
	}
	
	@Test
	public void testUpdateByPrescriptionnum() {
		int row = medicalRecordDao.updateByPrescriptionnum("王医生", "155798535995");
		System.out.println(row);
	}
}
