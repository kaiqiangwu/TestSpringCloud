package com.cy.hisystem.service;

import com.cy.hisystem.pojo.RegisterPojo;

/**
 * 挂号表相关操作接口
 * @author 李溢
 *
 */
public interface RegisterService {
    /**
     * 新增挂号信息
     * @param registerPojo 挂号信息实例
     * @return 受影响的行数
     */
    int insertRegister(RegisterPojo registerPojo);
    
    /**
     * 根据挂号表id查询挂号记录
     * @param id:挂号表id
     * @return 挂号表记录
     */
    RegisterPojo findById(String id);
}
