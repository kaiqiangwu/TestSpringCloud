package com.cy.hisystem.service;



import java.util.List;

import com.cy.hisystem.pojo.MedicalRecordPojo;
import com.cy.hisytem.pojo.vo.MedicalRecordRegisterVo;

/**
 * 
 * @author by 陈胜
 *
 */
public interface TollService {
	
	/**
	 * 获取病例信息
	 * @param cardId
	 * @param tollStatus
	 * @return
	 * @throws IllegalAccessException 
	 */
	List<MedicalRecordRegisterVo>getlistRegistinfo(String cardId,String tollStatus) throws IllegalAccessException;
	
	/**
	 * 更新挂号信息以及对应的处方信息
	 * 
	 * @param reqVO
	 */
	void SaveMedicalRecordPojo(MedicalRecordPojo reqVO);
	
}
