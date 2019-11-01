package com.cy.hisystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.DrugDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.DrugPojo;
import com.cy.hisystem.service.DrugManageService;

/**
 * 
 * @author 肖家睿
 *	药物管理模块
 *	1)查询方法	findDrugObjects
 *	2)删除	deleteDrug
 *	3)修改	updateDrug
 */
@Service
public class DrugManagerServiceImpl implements DrugManageService{
	@Autowired
	private DrugDao drugDao;
	/**根据筛选条件/查询药品信息*/

	@Override
	public List<DrugPojo> findDrugObjects(String name, String drugType, Integer limitStatus,
			String efficacyClassification) {
		System.out.println("123"+name);
		System.out.println("456"+drugType);
		System.out.println("789"+limitStatus);
		System.out.println("123"+efficacyClassification);
		List<DrugPojo> selectFindDrugObjects = drugDao.findDrugObjects(name, drugType, limitStatus, efficacyClassification);
		for (DrugPojo drugPojo : selectFindDrugObjects) {
			System.out.println(drugPojo);
		}
		return selectFindDrugObjects;
	}
	
	/**删除药品信息*/
	@Override
	public int deleteDrug(String name) {
		int deleteDrugRow = drugDao.deleteDrug(name);
		return deleteDrugRow;
	}

	/**修改药品信息*/
	@Override
	public int updateDrug(DrugPojo drugPojo) {
		/**获取药品名称*/
		String name = drugPojo.getName();
		/**获取药品剂型*/
		String drugType = drugPojo.getDrugType();
		/**获取药品规格*/
		String specification = drugPojo.getSpecification();
		/**获取药品单位*/
		String unit = drugPojo.getUnit();
		/**获取药品是否限制*/
		int limitStatus = drugPojo.getLimitStatus();
		/**获取药品功效分类*/
		String efficacyClassification = drugPojo.getEfficacyClassification();
		/**获取药品批发价*/
		double wholesalePrice = drugPojo.getWholesalePrice();
		/**获取药品批发价*/
		double price = drugPojo.getPrice();
		/**获取药品生产日期*/
		String productionDate = drugPojo.getProductionDate();
		/**获取药品保质期*/
		String qualityDate = drugPojo.getQualityDate();
		/**获取生产厂家*/
		String manufacturer = drugPojo.getManufacturer();
		/**字段效验判断*/
		if (name==null || name=="") {
			throw new ServiceException("药品名称不能为空");
		}
		if (drugType==null || drugType=="") {
			throw new ServiceException("药品剂型不能为空");
		}
		if (specification==null || specification=="") {
			throw new ServiceException("药品规格不能为空");
		}
		if (unit==null || unit=="") {
			throw new ServiceException("药品单位不能为空");
		}
		if (efficacyClassification==null || efficacyClassification=="") {
			throw new ServiceException("药品功效分类不能为空");
		}
		if (wholesalePrice==0 || wholesalePrice<0) {
			throw new ServiceException("批发价不合法");
		}
		if (price==0 || price<0) {
			throw new ServiceException("售价不合法");
		}
		if (productionDate==null || productionDate=="") {
			throw new ServiceException("药品生产日期不能为空");
		}
		if (qualityDate==null || qualityDate=="") {
			throw new ServiceException("药品保质期不能为空");
		}
		if (manufacturer==null || manufacturer=="") {
			throw new ServiceException("生产厂家不能为空");
		}
		int updateDrug = drugDao.updateDrug(drugPojo);
		return updateDrug;
	}
}
