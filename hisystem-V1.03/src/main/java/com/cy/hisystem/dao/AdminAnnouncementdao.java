package com.cy.hisystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.hisytem.pojo.vo.AnnouncementVo;
import com.github.pagehelper.PageInfo;

@Mapper
/**
 * 公告数据层
 * 接口文件
 * @author Leo 徐忠春
 *
 */
public interface AdminAnnouncementdao {
	/**
	 * 添加公告
	 */
	int addAnnouncement(AnnouncementVo anno);
	/**
	 * 查看所有公告
	 */
	ArrayList<AnnouncementVo> findAnnouncement();
	/**
	 * 根据id删除公告
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
	/**
	 * 查询总数
	 */
	@Select("select count(*) from his_announcement")
	long findTotal();

}
