package com.cy.hisystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Announcement业务页面控制层
 * @author Leo 徐忠春
 *
 */
@Controller
public class AnnouncementPageController {
	/**
	 * 通用页面
	 * @param page
	 * @return
	 */
	@RequestMapping("{page}")
	public String page(@PathVariable String page) {
		return page;
		
	}
	
	/**
	 * 公告页面
	 * @return
	 */
	 @RequestMapping("/announcement")
	    public String doAnnouncement() {
	        return "admin/announcement";
	    }
	

}
