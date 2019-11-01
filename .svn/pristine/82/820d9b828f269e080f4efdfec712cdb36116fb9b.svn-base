package com.cy.hisystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.IdCardDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.IdCardPojo;
import com.cy.hisystem.service.IdCardService;
/**
 * 此类为IdCardService业务实现类
 * @author 李溢
 *
 */
@Service
public class IdCardServiceImpl implements IdCardService{
    
    /**注入接口*/
    @Autowired
    private IdCardDao idCardDao;
    
    /**
     * 根据就诊卡id查询就诊卡信息业务实现
     */
    @Override
    public IdCardPojo selectIdCardPojoByCardNumber(String cardId) {
        if(null==cardId||"".equals(cardId)) {
            throw new IllegalArgumentException("卡号输入有误!");
        }
        IdCardPojo idCard = idCardDao.selectIdCardPojoByCardNumber(cardId);
        if(null==idCard) {
            throw new ServiceException("未查询到就诊卡信息!");
        }
        return idCard;
    }
    
    /**
     * 新增就诊卡信息业务实现
     */
    @Override
    public int insertIdCard(IdCardPojo idCardPojo) {
        if(null==idCardPojo) {
            throw new IllegalArgumentException("参数异常!");
        }
        return idCardDao.insertIdCard(idCardPojo);
    }

}
