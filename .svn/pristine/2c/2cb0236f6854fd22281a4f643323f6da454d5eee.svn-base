package com.cy.hisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cy.hisystem.pojo.IdCardPojo;
import com.cy.hisystem.pojo.RegisterPojo;
import com.cy.hisystem.service.IdCardService;
import com.cy.hisystem.service.RegisterService;
import com.cy.hisystem.vo.JsonResult;

/**
 * 挂号表数据控制层
 * @author 李溢
 *
 */
@RestController
@RequestMapping("/register/")
public class RegisterController {
    
    @Autowired
    private RegisterService registerService;
    
    @Autowired
    private IdCardService idCardService;
    /**新增挂号表信息*/
    @RequestMapping("addRegisterInfor")
    public JsonResult insertRegister(@RequestBody RegisterPojo registerPojo) {
        registerService.insertRegister(registerPojo);
        return new JsonResult("添加成功!");
    }
    
    /**根据就诊卡id查询就诊卡信息*/
    @RequestMapping("getIDcardInfor")
    public JsonResult selectIdCardPojoByCardNumber(@RequestParam String cardId) {
        return new JsonResult(idCardService.selectIdCardPojoByCardNumber(cardId));
    }
}
