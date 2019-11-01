package com.cy.hisystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.hisystem.dao.RegisterRecordDao;
import com.cy.hisystem.pojo.RegisterRecord;
import com.cy.hisystem.service.RegisterRecordService;
import com.cy.hisystem.vo.JsonResult;


/**
 * 
 * @author 陈旭升
 *挂号记录查询Conller
 */
@RequestMapping("/register/")
@RestController
public class RegisterRecordController {
/**调用service层接口*/
  @Autowired
  private RegisterRecordService registerRecordService;
 
/**数据返回json串形势*/
  @RequestMapping("doFindObjects")
	public JsonResult doFindObjects(String department, String registerType, String createDatetime,
			String endDatetime) {
		return new JsonResult(registerRecordService.findObjects(department, registerType, createDatetime, endDatetime));
	}
  @RequestMapping("getRegisterRecord")
	public List<RegisterRecord> getRegisterRecord(String department, String registerType, String startTime,
			String endTime) {
	
		List<RegisterRecord> data = registerRecordService.findObjects(department, registerType, startTime, endTime);
		
		return data;
	}

}