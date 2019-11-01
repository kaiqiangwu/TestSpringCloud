package com.cy.hisystem.pojo;

import java.io.Serializable;

/**
 * 挂号表实体类
 *
 * @author 吴凯强
 */
public class RegisterPojo implements Serializable{

	/** 序列化id */
	private static final long serialVersionUID = -600805925680505490L;

	/** 挂号id */
	private String id; 

	/** 挂号时间 */
	private String createDatetime;

	/** 所挂科室 */
	private String department;
	
	/** 所挂医生 */
	private String doctor;

	/** 支付方式 */
	private String payType;
	
	/**  挂号类型(门诊类型) */
	private String registerType;
	
	/** 挂号费用 */
	private String treatmentPrice;

	/** 患者id */
	private String patientId;

	/** 操作员邮箱 */
	private String operatorEmail;

	/** 操作员姓名 */
	private String operatorName;
	
	/** 缴费状态 0:未收费  1：已收费*/
	private Integer chargeStatus;
	
	/** 挂号状态 */
	private Integer registerStatus;
	
	/** 就诊状态 */
	private Integer treatmentStatus;
	
	/** 就诊卡id（卡号） */
	private String registeredNum;
	
	/** 医生id */
	private String doctorId;

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getTreatmentPrice() {
		return treatmentPrice;
	}

	public void setTreatmentPrice(String treatmentPrice) {
		this.treatmentPrice = treatmentPrice;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getOperatorEmail() {
		return operatorEmail;
	}

	public void setOperatorEmail(String operatorEmail) {
		this.operatorEmail = operatorEmail;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getChargeStatus() {
		return chargeStatus;
	}

	public void setChargeStatus(Integer chargeStatus) {
		this.chargeStatus = chargeStatus;
	}

	public Integer getRegisterStatus() {
		return registerStatus;
	}

	public void setRegisterStatus(Integer registerStatus) {
		this.registerStatus = registerStatus;
	}

	public Integer getTreatmentStatus() {
		return treatmentStatus;
	}

	public void setTreatmentStatus(Integer treatmentStatus) {
		this.treatmentStatus = treatmentStatus;
	}

	public String getRegisteradNum() {
		return registeredNum;
	}

	public void setRegisteradNum(String registeradNum) {
		this.registeredNum = registeradNum;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public String toString() {
		return "RegisterPojo [id=" + id + ", createDatetime=" + createDatetime + ", department=" + department
				+ ", doctor=" + doctor + ", payType=" + payType + ", registerType=" + registerType + ", treatmentPrice="
				+ treatmentPrice + ", patientId=" + patientId + ", operatorEmail=" + operatorEmail + ", operatorName="
				+ operatorName + ", chargeStatus=" + chargeStatus + ", registerStatus=" + registerStatus
				+ ", treatmentStatus=" + treatmentStatus + ", registeradNum=" + registeredNum + ", doctorId=" + doctorId
				+ "]";
	}

	
	
}
