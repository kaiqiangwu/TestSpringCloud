package com.cy.hisystem.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.DrugDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.DrugPojo;
import com.cy.hisystem.pojo.DrugTypePojo;
import com.cy.hisystem.pojo.EfficacyClassificationPojo;
import com.cy.hisystem.service.DrugService;

/**
 * DrugService的实现类，具体实现药物处理业务相关
 * 
 * @author 黄德傲
 *
 */
@Service
public class DrugServiceImpl implements DrugService {
	/** DrugDao对象 */
	@Autowired
	private DrugDao drugDao;

	/**
	 * 获取数据库中所有的药品类别
	 */
	@Override
	public List<String> getAllDrugType() {
		// 从数据库中获取药品类型信息
		List<DrugTypePojo> drugType = drugDao.getAllDrugType();
		// 判断drugType是否为空
		if (drugType == null) {
			throw new ServiceException("查询不到数据！");
		}
		List<String> data = new LinkedList<>();
		// 获取List每个元素中 包含的类别信息
		for (DrugTypePojo d : drugType) {
			data.add(d.getDrugType());
		}
		return data;
	}

	@Override
	public List<String> getAllEfficacyClassification() {
		List<String> allEfficacyClassification = drugDao.getAllEfficacyClassification();
		if (allEfficacyClassification == null) {
			throw new ServiceException("未查询到相关数据！");
		}
		return allEfficacyClassification;
	}

	@Override
	public int addNewDrug(DrugPojo drugPojo) {
		// 查询数据库是否已有相同name的药品信息
		int count = drugDao.findDrugCountByName(drugPojo.getName());
		if (count > 0) {
			throw new ServiceException("数据库中已经有这种药了！");
		}
		// 获取当前系统时间
		Date date = new Date();
		// 格式化date对象
		String dateString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date).toString();
		// 设置drugPojo对象的createDatetime属性
		drugPojo.setCreateDatetime(dateString);
		// 生成drugPojo对象的id，规则是【当前时间字符串】+【100以内随机整数】
		int nextInt = new Random().nextInt(100);
		String id = dateString + Integer.toString(nextInt);
		// 设置drugPojo对象的id
		drugPojo.setId(id);
		// 执行数据库插入操作
		int rows = drugDao.addNewDrug(drugPojo);
		return rows;
	}

	@Override
	public List<String> getAllDrugName() {
		// 获取所有药品信息封装到药品实体类
		List<DrugPojo> allDrug = drugDao.findDrugObjects(null,null,null,null);
		// 判断是否获取到药品信息
		if (allDrug == null) {
			throw new ServiceException("找不到相关药品信息！");
		}
		// 取出所有药品名称
		List<String> drugName = new LinkedList<>();
		for (DrugPojo drug : allDrug) {
			drugName.add(drug.getName());
		}
		return drugName;
	}

	@Override
	public DrugPojo getDrugInfor(String drugName) {
		// 获取所有药品信息封装到药品实体类
		List<DrugPojo> allDrug = drugDao.findDrugObjects(null,null,null,null);
		// 判断是否获取到药品信息
		if (allDrug == null) {
			throw new ServiceException("找不到相关药品信息！");
		}
		// 取出名字为drugName的药品信息
		for (DrugPojo drug : allDrug) {
			if (drugName.equals(drug.getName())) {
				return drug;
			}
		}
		throw new ServiceException("找不到相关药品信息！");
	}

	@Override
	public int addStorageQuantity(String drug, Integer addStorageQuantity) {
		if (drug == null) {
			throw new ServiceException("服务器维护中，更新失败！");
		}
		// 判断数量是否正确
		if (addStorageQuantity <= 0) {
			throw new ServiceException("请输入正确的入库数量！");
		}
		// 执行插入操作
		int rows = drugDao.addStorageQuantity(drug, addStorageQuantity);
		if (rows != 1) {
			throw new ServiceException("服务器维护中，更新失败！");
		}
		return rows;
	}

	@Override
	public int addDrugType(String drugType) {
		List<DrugTypePojo> allDrugType = drugDao.getAllDrugType();
		if (drugType == null || "".equals(drugType)) {
			throw new ServiceException("请输入正确的剂型名称！");
		}
		if (allDrugType != null) {
			for (DrugTypePojo s : allDrugType) {
				if (s.getDrugType().equals(drugType)) {
					throw new ServiceException("数据库中已经有这种剂型了！");
				}
			}
		}
		// 获取当前系统时间并转换成字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
		String dateStr = sdf.format(new Date()).toString();
		// 新建DrugTypePojo对象
		DrugTypePojo drugTypePojo = new DrugTypePojo();
		// 设置创建日期
		drugTypePojo.setCreateDatetime(dateStr);
		// 生成id，规则是【当前时间字符串】+【100以内随机数】
		int nextInt = new Random().nextInt(100);
		String idStr = dateStr + nextInt;
		// 设置id
		drugTypePojo.setId(idStr);
		// 设置新剂型名
		drugTypePojo.setDrugType(drugType);
		// 插入数据库
		int rows = drugDao.addDrugType(drugType);
		if (rows != 1) {
			throw new ServiceException("数据更新失败！");
		}
		return rows;
	}

	@Override
	public int addEfficacyClassification(String efficacyClassification) {
		List<String> allEfficacyClassification = drugDao.getAllEfficacyClassification();
		if (efficacyClassification == null || "".equals(efficacyClassification)) {
			throw new ServiceException("请输入正确的功效！");
		}
		if (allEfficacyClassification != null) {
			for (String aEC : allEfficacyClassification) {
				if (aEC.equals(efficacyClassification)) {
					throw new ServiceException("数据库中已经有这种功效类型了！");
				}
			}
		}
		// 获取当前系统时间并转换成字符串
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:HH:ss");
		String dateStr = sdf.format(new Date()).toString();
		// 新建efficacyClassificationPojo对象
		EfficacyClassificationPojo efficacyClassificationPojo = new EfficacyClassificationPojo();
		// 设置创建日期
		efficacyClassificationPojo.setCreateDatetime(dateStr);
		// 生成id，规则是【当前时间字符串】+【100以内随机数】
		int nextInt = new Random().nextInt(100);
		String idStr = dateStr + nextInt;
		// 设置id
		efficacyClassificationPojo.setId(idStr);
		// 设置新剂型名
		efficacyClassificationPojo.setEfficacyClassification(efficacyClassification);
		// 插入数据库
		int rows = drugDao.addEfficacyClassification(efficacyClassificationPojo);
		if (rows != 1) {
			throw new ServiceException("数据更新失败！");
		}
		return rows;
	}

}
