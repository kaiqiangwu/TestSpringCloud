package com.cy.hisystem.controller;

import com.cy.hisystem.pojo.MedicalRecordPojo;
import com.cy.hisystem.service.MedicalRecordService;
import com.cy.hisystem.service.TollService;
import com.cy.hisystem.vo.JsonResult;
import com.cy.hisytem.pojo.vo.MedicalRecordRegisterVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 陈胜
 * @date 2019-9-18
 * @description:
 */
@RestController
@RequestMapping(value = "/toll")
public class TollController {

    @Autowired
    private TollService tollService;
    
    @Autowired
    private MedicalRecordService medicalRecordservice;


    
    /**
     * 获取病历信息
     *
     * @param cardId 卡号
     * @param tollStatus 缴费状态
     * @return
     * @throws IllegalAccessException 
     */
    @RequestMapping(value = "/getAllMedicalRecord")
    public JsonResult getAllMedicalRecord(@RequestParam String cardId,
                                               @RequestParam String tollStatus) throws IllegalAccessException {
    	
        return new JsonResult(tollService.getlistRegistinfo(cardId, tollStatus));
    }

    /**
     * 获取处方笺信息
     *
     * @param cardId 卡号
     * @param registerId 处方号
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/getMedicalRecord")
    public JsonResult getMedicalRecord(@RequestParam String cardId,
                                                   @RequestParam String prescriptionNum) throws Exception {
        return new JsonResult(medicalRecordservice.findByPrescriptionnum(prescriptionNum));
    }


    /**
     * 划价收费完成，保存信息
     *
     * @param reqVO
     * @return
     */
    @PostMapping(value = "/saveTollInfo")
    public JsonResult saveTollInfo(@RequestBody MedicalRecordPojo medicalRecordPojo) {

    	tollService.SaveMedicalRecordPojo(medicalRecordPojo);
    	
    	return new JsonResult("SUCCESS");
		
        
    }
}
