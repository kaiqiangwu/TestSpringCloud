package com.cy.hisystem.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.hisystem.service.UserService;
import com.cy.hisystem.vo.JsonResult;
import com.cy.hisytem.pojo.vo.SignupVo;
/**
 * 
 * @author 黄德傲 吴凯强
 *
 */
@RestController
@RequestMapping("/user/")
public class LoginSignupController {
	
	@Autowired
	UserService userService;

	/**
	 * 用户验证
	 * @param signupVo
	 * @return
	 */
	@RequestMapping("dologin")
    public JsonResult dologin(@RequestBody SignupVo signupVo) {
		System.out.println(signupVo);
		boolean flag = userService.doLoginChecking(signupVo.getEmail(), signupVo.getPassword());
		return new JsonResult("登录成功！");
    }
	
	/**
	 * 执行注册操作
	 * @param signupVo 注册信息
	 * @return
	 */
	@RequestMapping("doregister")
	public JsonResult doregister(@RequestBody SignupVo signupVo) {
		userService.insertUser(signupVo);
		
		return new JsonResult("ok");
	}
}

