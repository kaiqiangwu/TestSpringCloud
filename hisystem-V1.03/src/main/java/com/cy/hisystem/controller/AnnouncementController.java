package com.cy.hisystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.hisystem.pojo.PagePojo;
import com.cy.hisystem.service.AnnouncementService;
import com.cy.hisystem.vo.JsonResult;
import com.cy.hisytem.pojo.vo.AnnouncementVo;

@Controller
@RequestMapping("/admin")
/**
 * Controller控制层
 * @author Leo 徐忠春
 *
 */
public class AnnouncementController {
	@Autowired
	private AnnouncementService announcementService;

	/**
	 * 添加公告
	 * @return
	 */
	@RequestMapping("/addAnnouncement")
	@ResponseBody
	public JsonResult addAnnouncement(@RequestBody AnnouncementVo anno) {
		announcementService.addAnnouncement(anno);
		return new JsonResult("insert ok");

	}

	/**
	 * 查看所有公告
	 * @return 
	 */
	@RequestMapping("/getAnnouncement")
	@ResponseBody
	public  PagePojo<AnnouncementVo> getAnnouncement(Integer pageNumber) {
		PagePojo<AnnouncementVo> list = announcementService.findAnnouncement(pageNumber);
		return list;


	}
	/**
	 * 删除公告
	 */
	@RequestMapping("/deleteAnnouncement")
	@ResponseBody
	public  JsonResult deleteAnnouncement(String id) {
		int delete = announcementService.deleteAnnouncement(id);
		return new JsonResult(delete);


	}
	

	/**
	 * 根据id修改公告
	 */
	@RequestMapping("/changeAnnouncement")
	@ResponseBody
	public JsonResult changeAnnouncement(@RequestBody AnnouncementVo anno) {
		int admin = announcementService.updateAnnouncement(anno);
		return new JsonResult(admin);

	}
	
	
	/**
	 * 把公告添加到主页显示
	 */
	@RequestMapping("/add_Announcement")
	@ResponseBody
	public JsonResult inserAtnouncement(AnnouncementVo anno) {
		int add = announcementService.insertAnnouncement(anno);
		return new JsonResult(add);
		
		
	}
	
	/**
	 * 把公告从主页移除
	 */
	@RequestMapping("/sub_Announcement")
	@ResponseBody
	public JsonResult supAtnouncement(AnnouncementVo anno) {
		int sub = announcementService.subAnnouncement(anno);
		return new JsonResult(sub);	
	}


}
