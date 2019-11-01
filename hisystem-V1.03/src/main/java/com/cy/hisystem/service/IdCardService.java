package com.cy.hisystem.service;

import com.cy.hisystem.pojo.IdCardPojo;

/**
 * 此接口用于定义就诊卡注册时需要业务实现的方法
 * @author 李溢
 *
 */
public interface IdCardService {
    /**
     * 根据就诊卡号查询就诊卡实例对象
     * @param cardnumber 就诊卡号
     * @return IdCardPojo 实例对象
     */
    IdCardPojo selectIdCardPojoByCardNumber(String cardId);
    
    /**
     * 新增就诊卡信息
     * @param idCardPojo 实例对象
     * @return 影响行数
     */
    int insertIdCard(IdCardPojo idCardPojo);
}
