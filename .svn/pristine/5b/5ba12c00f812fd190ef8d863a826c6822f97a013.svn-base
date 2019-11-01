package com.cy.hisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.hisystem.service.MedicalRecordService;
import com.cy.hisystem.vo.JsonResult;
import com.cy.hisytem.pojo.vo.MedicalRecordRegisterVo;

/**
 * 取药页面控制层
 *
 * @author 吴凯强
 */
@ResponseBody
@Controller
@RequestMapping("/takingdrug/")
public class TakingDrugController {
	
	@Autowired
	MedicalRecordService medicalRecordService;
	
	/**
	 * 查询过处方信息
	 * @param prescriptionNum 处方号
	 * @return
	 */
	@RequestMapping("getMedicalRecord")
	public JsonResult getMedicalRecord(String prescriptionNum) {
		MedicalRecordRegisterVo medicalRecordRegisterVo = medicalRecordService.findByPrescriptionnum(prescriptionNum);
		return new JsonResult(medicalRecordRegisterVo);
	}
	
	@RequestMapping("saveTakingDrugInfo")
	public JsonResult saveTakingDrugInfo(String prescriptionNum ) {
		System.out.println(prescriptionNum);
		String tollOperator = "王医生";
		medicalRecordService.updateByPrescriptionnum(tollOperator, prescriptionNum);
		return new JsonResult();
	}
	
}
