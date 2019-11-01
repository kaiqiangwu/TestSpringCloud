package com.cy.hisystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.hisystem.pojo.IdCardPojo;
import com.cy.hisystem.service.IdCardService;
import com.cy.hisystem.vo.JsonResult;

/**
 * 就诊卡注册控制类
 * @author 李溢
 *
 */
@RestController
@RequestMapping("/idCard/")
public class IdCardController {
    
    @Autowired
    private IdCardService idCardService;
    
    /**根据就诊卡id查询就诊卡信息*/
    @RequestMapping("findIdById")
    public JsonResult selectIdCardPojoByCardNumber(String cardId) {
        return new JsonResult(idCardService.selectIdCardPojoByCardNumber(cardId));
    }
    
    /**新增就诊卡*/
    @RequestMapping("addIdCard")
    public JsonResult insertIdCard(@RequestBody IdCardPojo idCardPojo) {
        //System.out.println(idCardPojo);
        idCardService.insertIdCard(idCardPojo);
        return new JsonResult("办理成功!");
    };
}
