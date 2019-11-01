package com.cy.hisystem.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.hisystem.pojo.MedicalRecordPojo;
import com.cy.hisystem.pojo.PatientInforRspPojo;
import com.cy.hisystem.service.DrugService;
import com.cy.hisystem.service.OutpatientServiceService;
import com.cy.hisystem.vo.JsonResult;
/**
 * @author 张孙传 黄德傲
 * 控制层
 * 门诊页面的数据获取
 */
@RestController
@RequestMapping("/outpatient/")
public class OutpatienServiceController {
	
	@Autowired
	private OutpatientServiceService outpatienServiceService;
	@Autowired
	private DrugService drugService;
	
	/**根据就诊卡id查询病人信息*/
	@RequestMapping("getPatientByCardId")
	public JsonResult getPatientByCardId(String cardId) {
		System.out.println(cardId);
		System.out.println(outpatienServiceService.findPatientInforRsp(cardId));
		return new JsonResult(
				outpatienServiceService.findPatientInforRsp(cardId));
	}
	
	/**修改病人信息*/
	@RequestMapping("changePatientInfor")
	public JsonResult changePatientInfor(
			@Param("career")String career,
			@Param("familyHistory")String familyHistory,
			@Param("maritalStatus")String maritalStatus,
			@Param("pastHistory")String pastHistory,
			@Param("personalHistory")String personalHistory) {
		System.err.println(111);
		int rows = outpatienServiceService.changePatientInfor(career, familyHistory, maritalStatus, pastHistory, personalHistory);
		return new JsonResult();
	}
	
	/**
	 * 	业务层获取所有药品信息
	 * @return	由药品名称组成的List
	 */
	@RequestMapping("getAllDrug")
	public JsonResult getAllDrug() {
		List<String> data = drugService.getAllDrugName();
		return new JsonResult(data);
	}
	
	@RequestMapping("addMedicalRecord")
	public JsonResult addMedicalRecord(MedicalRecordPojo medicalRecordPojo) {
		outpatienServiceService.addMedicalRecord(medicalRecordPojo);
		return new JsonResult("操作成功");
	}
	

}
