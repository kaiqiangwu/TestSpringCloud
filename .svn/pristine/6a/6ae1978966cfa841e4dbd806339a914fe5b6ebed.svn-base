package com.cy.hisystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cy.hisystem.pojo.DrugPojo;
import com.cy.hisystem.pojo.DrugTypePojo;
/**
 * 处理新药品信息入库、药品入库业务
 * @author 黄德傲
 *
 */
public interface DrugService {
	
	/**
	 * 查找数据库中所有药品类别
	 * @return	返回所有药品类别的List
	 */
	List<String> getAllDrugType();
	
	/**
	 * 查找数据库his_drug中所有药品的功效
	 * @return 所有药品功效组成的List
	 */
	List<String> getAllEfficacyClassification();
	
	/**
	 * 向数据库中新药品
	 * @param drugPojo 前端获取的药品信息
	 * @return
	 */
	int addNewDrug(@Param("DrugPojo")DrugPojo drugPojo);
	
	/**
	 * 获取所有药品名称
	 * @return	由药品名称组成的List
	 */
	List<String> getAllDrugName();
	
	/**
	 * 获取指定名称的药品的所有信息
	 * @param drugName
	 * @return
	 */
	DrugPojo getDrugInfor(String drugName);
	
	/**
	 * 向数据库中更新指定药品名称的药品的库存量
	 * @param drug 指定药品
	 * @param addStorageQuantity	要添加的数量
	 * @return
	 */
	int addStorageQuantity(
			@Param("drugName")String drug,
			@Param("addStorageQuantity")Integer addStorageQuantity);
	
	/**
	 * 向数据库插入新的药品类型
	 * @param drugType	前端传入的新剂型名称
	 * @return
	 */
	int addDrugType(String drugType);
	
	/**
	 * 	插入新的药品功效
	 * @param efficacyClassification	前端获取的新药品功效
	 * @return
	 */
	int addEfficacyClassification(String efficacyClassification);
}
