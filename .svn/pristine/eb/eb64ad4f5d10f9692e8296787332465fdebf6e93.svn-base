package com.cy.hisystem.controller;

import javax.websocket.server.PathParam;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cy.hisystem.service.UserService;
import com.cy.hisystem.vo.JsonResult;
import com.cy.hisytem.pojo.vo.SignupVo;

/**
 * 用户表控制类
 * @author 李溢
 *
 */
@RestController
@RequestMapping("/user/")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("getAllRegisterDoctor")
    public JsonResult getAllRegisterDoctor(String department,String registerType){
        return new JsonResult(userService.getAllRegisterDoctor(department, registerType));
    }
}
