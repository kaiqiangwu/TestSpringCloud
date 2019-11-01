package com.cy.hisytem.pojo.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
/**
 * @author Leo 徐忠春
 * 数据层，封装公告的数据信息
 *
 */

public class AnnouncementVo implements Serializable {
	private static final long serialVersionUID 
	= 2976367657089473504L;

	/*id号*/
	private String id;
	/*标题*/
	private String title;
	/*创建时间*/
	private Date createDatetime;
	/*内容*/
	private String contents;
	/*状态栏*/
	private Integer annStatus;
	/*修改时间*/
	private Date annDate;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Integer getAnnStatus() {
		return annStatus;
	}
	public void setAnnStatus(Integer annStatus) {
		this.annStatus = annStatus;
	}
	public Date getAnnDate() {
		return annDate;
	}
	public void setAnnDate(Date annDate) {
		this.annDate = annDate;
	}
	@Override
	public String toString() {
		return "AnnouncementVo [id=" + id + ", title=" + title + ", createDatetime=" + createDatetime + ", contents="
				+ contents + ", annStatus=" + annStatus + ", annDate=" + annDate + "]";
	}




}
