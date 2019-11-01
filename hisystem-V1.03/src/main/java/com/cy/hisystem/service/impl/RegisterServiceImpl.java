package com.cy.hisystem.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.hisystem.dao.RegisterDao;
import com.cy.hisystem.exception.ServiceException;
import com.cy.hisystem.pojo.RegisterPojo;
import com.cy.hisystem.service.RegisterService;

/**
 * 挂号收费业务实现类
 * @author 李溢
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService{
    
    @Autowired
    private RegisterDao registerDao;
    
    @Override
    public int insertRegister(RegisterPojo registerPojo) {
        registerPojo.setId(UUID.randomUUID().toString().substring(0,16));
        int rows = registerDao.insertRegister(registerPojo);
        if(1>rows) {
            throw new ServiceException("插入失败!");
        }
        return rows;
    }

    @Override
    public RegisterPojo findById(String id) {
        if(null==id) {
            throw new IllegalArgumentException("参数异常!");
        }
        RegisterPojo registerPojo = registerDao.findById(id);
        if(null==registerPojo) {
            throw new ServiceException("记录可能已经不存在!");
        }
        return registerPojo;
    }

}
