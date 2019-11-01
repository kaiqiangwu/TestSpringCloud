package com.cy.hisystem.dao;
/**
 * 本接口用于定义有关就诊卡注册需要用到的SQL语句对应的方法
 * 对应mapper为:RegisterMapper.xml
 * @author 李溢
 *
 */

import org.apache.ibatis.annotations.Mapper;

import com.cy.hisystem.pojo.IdCardPojo;
@Mapper
public interface IdCardDao {
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

    
//    IdCardPojo findIdCar
}
