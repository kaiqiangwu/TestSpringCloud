package com.cy.hisystem.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.DrugPojo;
import com.cy.hisystem.service.DrugManageService;
import com.cy.hisystem.service.DrugService;
import com.cy.hisystem.vo.JsonResult;

/**
 * 
 * @author 肖家睿 黄德傲
 *
 */
@RestController
@RequestMapping("/drugstore/")
public class DrugController {

	@Autowired
	private DrugManageService drugManageService;

	@Autowired
	private DrugService drugService;

	/** 肖家睿:获取药物管理Json字符串类 */
	@RequestMapping("getAllDrug")
	public JsonResult doFindObjects(
			@RequestParam("drug")String drug, 
			@RequestParam("drugType_search")String drugTypeSearch, 
			@RequestParam("limitStatus_search")Integer limitStatusSearch,
			@RequestParam("efficacyClassification_search")String efficacyClassificationSearch) {
		 List<DrugPojo> findDrugObjects = drugManageService.findDrugObjects(drug, drugTypeSearch, limitStatusSearch,efficacyClassificationSearch);
		
		  System.out.println("Test:"+drug);
		  System.out.println("Test:"+drugTypeSearch);
		  System.out.println("Test:"+limitStatusSearch);
		  System.out.println("Test:"+efficacyClassificationSearch);
		 
		 JsonResult result = new JsonResult(findDrugObjects);
		 System.out.println(result.getData());
		 return result;
	}
	/** 肖家睿:删除药物信息 */
	@RequestMapping("deleteDrug")
	public JsonResult deleteDrug(String drugName) {
		int deleteDrugRow = drugManageService.deleteDrug(drugName);
		if (deleteDrugRow == 0) {
			throw new ServiceException("数据不存在!");
		}
		return new JsonResult("delete ok");
	}
	/** 肖家睿:修改药物信息 */
	@RequestMapping("updateDrug")
	public JsonResult updateDrug(DrugPojo drugPojo) {
		/*
		 * String name = drugPojo.getName(); String drugType = drugPojo.getDrugType();
		 * String specification = drugPojo.getSpecification(); String manufacturer =
		 * drugPojo.getManufacturer(); System.out.println(drugPojo);
		 * System.out.println("药品名称:"+name); System.out.println("drugType:"+drugType);
		 * System.out.println("specification:"+specification);
		 * System.out.println("manufacturer:"+manufacturer);
		 */
		int updateDrug = drugManageService.updateDrug(drugPojo);
		if (updateDrug == 0) {
			throw new ServiceException("修改异常!");
		}
		return new JsonResult("update ok");
	}

	/**
	 * 从业务层获取所有药品类别信息
	 * 
	 * @return 由药品类别组成的List
	 */
	@RequestMapping("getAllDrugType")
	public JsonResult getAllDrugType() {
		List<String> data = drugService.getAllDrugType();
		return new JsonResult(data);
	}

	/**
	 * 通过业务层查找数据库his_drug中所有药品的功效
	 * 
	 * @return 所有药品功效组成的List
	 */
	@RequestMapping("getAllEfficacyClassification")
	public JsonResult getAllEfficacyClassification() {
		List<String> data = drugService.getAllEfficacyClassification();
		return new JsonResult(data);
	}

	/**
	 * 通过业务层向数据库中添加新药品
	 * 
	 * @param drugPojo 前端获取的药品信息
	 * @return
	 */
	@RequestMapping("addNewDrug")
	public JsonResult addNewDrug(DrugPojo drugPojo) {
		System.out.println(drugPojo);
		drugService.addNewDrug(drugPojo);
		return new JsonResult("药物信息新增成功！");
	}

	/**
	 * 获取指定名字的药品全部信息
	 * 
	 * @param drug 前端页面传入的药品名称
	 * @return 此药品的全部信息
	 */
	@RequestMapping("getDrugInfor")
	public JsonResult getDrugInfor(String drug) {
		DrugPojo data = drugService.getDrugInfor(drug);
		return new JsonResult(data);
	}

	/**
	 * 向数据库指定名称药瓶添加库存
	 * 
	 * @param drug               前端传入的药品名称
	 * @param addStorageQuantity 要添加的数量
	 * @return
	 */
	@RequestMapping("addStorageQuantity")
	public JsonResult addStorageQuantity(String drug, Integer addStorageQuantity) {
		drugService.addStorageQuantity(drug, addStorageQuantity);
		return new JsonResult("库存添加成功！");
	}

	/**
	 * 向数据库插入新剂型信息
	 * 
	 * @param drugType 新剂型名称
	 * @return
	 */
	@RequestMapping("addDrugType")
	public JsonResult addDrugType(String drugType) {
		drugService.addDrugType(drugType);
		return new JsonResult("药物类别添加成功！");
	}

	@RequestMapping("addEfficacyClassification")
	public JsonResult addEfficacyClassification(String efficacyClassification) {
		drugService.addEfficacyClassification(efficacyClassification);
		return new JsonResult("药物功效添加成功！");
	}
}
