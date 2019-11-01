package com.cy.hisystem.service.impl;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.hisystem.dao.AdminAnnouncementdao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.PagePojo;
import com.cy.hisystem.service.AnnouncementService;
import com.cy.hisytem.pojo.vo.AnnouncementVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * AnnouncementServiceImpl 业务层实现类
 * @author Leo 徐忠春
 *
 */
@Service

public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired 
	private AdminAnnouncementdao adminAnnouncement;
	@SuppressWarnings({"rawtypes","unchecked"})
	/**
	 * 添加公告
	 */
	@Override
	public int addAnnouncement(AnnouncementVo anno) {
		if(anno==null) {
			throw new IllegalArgumentException("新增公告才能提交");
		}
		String str = UUID.randomUUID().toString();
		String id = str.replace("-", "");
		anno.setId(id);
		anno.setCreateDatetime(new Date());
		anno.setAnnStatus(0);
		anno.setAnnDate(new Date());
		int rows=adminAnnouncement.addAnnouncement(anno);
		return rows;
	}
	/**
	 * 分页查看所有公告
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public PagePojo<AnnouncementVo> findAnnouncement(Integer pageNum) {
		List<AnnouncementVo> list =  adminAnnouncement.findAnnouncement();
		long total = adminAnnouncement.findTotal();
		if(list.size()==0) {
			throw new ServiceException("未找到对应的记录");
		}
		PagePojo<AnnouncementVo> pagePojo = new PagePojo<>();
		pagePojo.setRows(list);
		pagePojo.setTotal(total);
		return pagePojo;
	}
	/**
	 * 根据id删除公告
	 */
	@Override
	public int deleteAnnouncement(String id) {
		if(id==null) {
			throw new ServiceException("请选择一个进行删除");
		}
		int rows = adminAnnouncement.deleteAnnouncement(id);
		if(rows<=0) {
			throw new ServiceException("删除失败,请重新尝试");
		}
		return rows;
	}
	/**
	 * 根据id修改公告
	 */
	@Override
	public int updateAnnouncement(AnnouncementVo anno) {
		//1.合法验证
		if(anno==null) {
			throw new ServiceException("修改对象不能为空");
		}
			
		if(StringUtils.isEmpty(anno.getTitle())) {
			throw new ServiceException("标题不能为空");
		}
			
		if(StringUtils.isEmpty(anno.getContents())) {
			throw new ServiceException("内容不能为空");
		}
			
			
		int rows = adminAnnouncement.updateAnnouncement(anno);
		if(rows<=0) {
			throw new ServiceException("修改失败,请重新尝试");
		}
		return rows;
	}
	/**
	 * 把公告添加到主页显示
	 */
	@Override
	public int insertAnnouncement(AnnouncementVo anno) {
		if(anno.getId()==null) {
			throw new IllegalArgumentException("请选择一个");
		}
		anno.setAnnStatus(1);
		int rows = adminAnnouncement.insertAnnouncement(anno);
		if(rows==0) {
			throw new ServiceException("添加到主页失败");
		}
		return rows;
	}
	
	/**
	 * 把公告从主页移除
	 */
	@Override
	public int subAnnouncement(AnnouncementVo anno) {
		if(anno.getId()==null) {
			throw new IllegalArgumentException("请选择一个");
		}
		anno.setAnnStatus(0);
		int rows = adminAnnouncement.subAnnouncement(anno);
		if(rows==0) {
			throw new ServiceException("添加到主页失败");
		}
		return rows;
		
	}








}
