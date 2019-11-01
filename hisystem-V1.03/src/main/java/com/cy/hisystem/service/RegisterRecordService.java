package com.cy.hisystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cy.hisystem.pojo.RegisterRecord;

/**
 * 
 * @author 陈旭升
 *service接口，用于挂号记录查询
 */

public interface RegisterRecordService {
//	RegisterRecord findObjects(@Param("his_register.department")String department,
//			                   @Param("his_register.register_type")String registerType,
//			                   @Param("createdatetime")String createDatetime);
	List<RegisterRecord> findObjects(@Param("department")String department,
	        @Param("registerType")String registerType,            
	        @Param("createdatetime")String createDatetime,
	        @Param("enddatetime")String endDatetime);
	

}
