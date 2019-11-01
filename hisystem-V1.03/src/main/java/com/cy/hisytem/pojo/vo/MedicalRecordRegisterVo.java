package com.cy.hisytem.pojo.vo;

import java.io.Serializable;

import com.cy.hisystem.pojo.MedicalRecordPojo;

/**
 * 封装挂号信息和患者信息
 *
 * @author 吴凯强 陈胜 
 */

public class MedicalRecordRegisterVo implements Serializable{
	
	/** 序列化id */
	private static final long serialVersionUID = -5934289728960087607L;

	/** 处方表信息 */
	private MedicalRecordPojo medicalRecord;
	
	/** 医生姓名 */
	private String doctorName;
	
	/** 患者科室类型 */
	private String department; 
	
	/**处方号*/
	private String prescriptionNum;

	/** 姓名 */
    private String name;

    /** 挂号费 */
    private String treatmentPrice;
    
    /** 性别 */
    private String sex;
    
    /** 民族 */
    private String nationality;
    
    /** 患者年龄 */
    private String age;
    
    /** 挂号类型 */
    private String registerType;
    
    
    
    public String getTreatmentPrice() {
		return treatmentPrice;
	}

	public void setTreatmentPrice(String treatmentPrice) {
		this.treatmentPrice = treatmentPrice;
	}

	public MedicalRecordRegisterVo() {
    	
    }

	public MedicalRecordPojo getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecordPojo medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getPrescriptionNum() {
		return prescriptionNum;
	}
	
	public void setPrescriptionNum(String prescriptionNum) {
		this.prescriptionNum = prescriptionNum;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	@Override
	public String toString() {
		return "MedicalRecordRegisterVo [medicalRecord=" + medicalRecord + ", doctorName=" + doctorName
				+ ", department=" + department + ", prescriptionNum=" + prescriptionNum + ", name=" + name
				+ ", treatmentPrice=" + treatmentPrice + ", sex=" + sex + ", nationality=" + nationality + ", age="
				+ age + ", registerType=" + registerType + "]";
	}



}
