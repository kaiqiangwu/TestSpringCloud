package com.cy.hisystem.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.RegisterRecordDao;
import com.cy.hisystem.exception.ServiceException;

import com.cy.hisystem.pojo.RegisterRecord;
import com.cy.hisystem.service.RegisterRecordService;
/**
 * 
 * @author 陈旭升
 * service实现类，调用dao层查询方法
 */
@Service
public class RegisterRecordSerivceImpl implements RegisterRecordService {
	/**dao层对象*/
	@Autowired
	private RegisterRecordDao registerRecordDao;
    /** 调用dao层的查询方法*/

	@Override
	public List<RegisterRecord> findObjects(String department, String registerType, String createDatetime,
			String endDatetime) {
		/**查询总数并效验*/
		List<RegisterRecord> record=registerRecordDao.findObjects(department, registerType, createDatetime, endDatetime);
		if(record==null) {
		    throw new  ServiceException("无查询数据");
		}
		return record;
	}

	

	
	
}
