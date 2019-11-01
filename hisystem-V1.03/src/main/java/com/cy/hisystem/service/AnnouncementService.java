package com.cy.hisystem.service;

import java.util.List;

import com.cy.hisystem.pojo.PagePojo;
import com.cy.hisytem.pojo.vo.AnnouncementVo;
import com.github.pagehelper.PageInfo;

/**
 * 
 * AnnouncementService业务层
 * @author Leo 徐忠春
 *
 */
public interface AnnouncementService {
	/**
	 * 添加公告
	 */
	int addAnnouncement(AnnouncementVo anno);
	/**
	 * 查看所有公告
	 */
	PagePojo<AnnouncementVo> findAnnouncement(Integer pageNum);
	/**
	 * 删除公告
	 */
	int deleteAnnouncement(String id);
	/**
	 * 根据id修改公告
	 */
	int updateAnnouncement(AnnouncementVo anno);
	/**
	 * 把公告添加到主页显示
	 */
	int insertAnnouncement(AnnouncementVo anno);
	/**
	 * 把公告从主页移除
	 */
	int subAnnouncement(AnnouncementVo anno);

	
	

}
