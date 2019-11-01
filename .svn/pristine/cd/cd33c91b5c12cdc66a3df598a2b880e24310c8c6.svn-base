package com.cy.hisystem.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;


import org.apache.ibatis.annotations.Mapper;

import com.cy.hisystem.pojo.RegisterPojo;

/**
 * 挂号收费相关方法接口
 * @author 李溢 吴凯强
 *
 */
@Mapper
public interface RegisterDao {
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
    
    /**
     * @param cardid:卡号   tollStatus：缴费状态
     * @return
     */
    List<RegisterPojo> getRegisterInfos(@Param("patientId") String patientId,@Param("tollStatus") String tollStatus);
    
    /**
     * 根据挂号id更新收费状态
     * @param registerPojo
     */
    void updateRegisterbyid(RegisterPojo registerPojo);

}
