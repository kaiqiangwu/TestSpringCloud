package com.cy.hisystem.pojo;

import java.io.Serializable;

/**
 * 
 * @author 肖家睿
 * drug实体类
 */
public class DrugPojo implements Serializable{
	private static final long serialVersionUID = 8170544245280463375L;
	/**药品序号*/
	private String id;
	/**药品创建日期*/
	private String createDatetime;
	/**剂型*/
	private String drugType;
	/**功效*/
	private String efficacyClassification;
	/**限制状态*/
	private Integer limitStatus;
	/**生产厂家*/
	private String manufacturer;
	/**药品名称*/
	private String name;
	/**药品编号*/
	private long num;
	/**药品售价*/
	private double price;
	/**规格*/
	private String specification;
	/**包装单位*/
	private String unit;
	/**药品批发价*/
	private double wholesalePrice;
	/**库存量*/
	private int storageQuantity;
	/**生产日期*/
	private String productionDate;
	/**保质日期*/
	private String qualityDate;
	
	public DrugPojo() {
		// TODO Auto-generated constructor stub
	}

	public DrugPojo(String id, String createDatetime, String drugType, String efficacyClassification,
			Integer limitStatus, String manufacturer, String name, long num, double price, String specification,
			String unit, double wholesalePrice, int storageQuantity, String productionDate, String qualityDate) {
		super();
		this.id = id;
		this.createDatetime = createDatetime;
		this.drugType = drugType;
		this.efficacyClassification = efficacyClassification;
		this.limitStatus = limitStatus;
		this.manufacturer = manufacturer;
		this.name = name;
		this.num = num;
		this.price = price;
		this.specification = specification;
		this.unit = unit;
		this.wholesalePrice = wholesalePrice;
		this.storageQuantity = storageQuantity;
		this.productionDate = productionDate;
		this.qualityDate = qualityDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}

	public String getEfficacyClassification() {
		return efficacyClassification;
	}

	public void setEfficacyClassification(String efficacyClassification) {
		this.efficacyClassification = efficacyClassification;
	}

	public Integer getLimitStatus() {
		return limitStatus;
	}

	public void setLimitStatus(Integer limitStatus) {
		this.limitStatus = limitStatus;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getWholesalePrice() {
		return wholesalePrice;
	}

	public void setWholesalePrice(double wholesalePrice) {
		this.wholesalePrice = wholesalePrice;
	}

	public int getStorageQuantity() {
		return storageQuantity;
	}

	public void setStorageQuantity(int storageQuantity) {
		this.storageQuantity = storageQuantity;
	}

	public String getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(String productionDate) {
		this.productionDate = productionDate;
	}

	public String getQualityDate() {
		return qualityDate;
	}

	public void setQualityDate(String qualityDate) {
		this.qualityDate = qualityDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DrugPojo [id=" + id + ", createDatetime=" + createDatetime + ", drugType=" + drugType
				+ ", efficacyClassification=" + efficacyClassification + ", limitStatus=" + limitStatus
				+ ", manufacturer=" + manufacturer + ", name=" + name + ", num=" + num + ", price=" + price
				+ ", specification=" + specification + ", unit=" + unit + ", wholesalePrice=" + wholesalePrice
				+ ", storageQuantity=" + storageQuantity + ", productionDate=" + productionDate + ", qualityDate="
				+ qualityDate + "]";
	}

}
