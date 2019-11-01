package com.cy.hisystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.hisystem.pojo.RegisterRecord;

/**
 * 
 * @author 陈旭升
 *此接口用于挂号记录查询
 */
@Mapper
public interface RegisterRecordDao {
List<RegisterRecord> findObjects(@Param("department")String department,
        @Param("registerType")String registerType,            
        @Param("createdatetime")String createDatetime,
        @Param("enddatetime")String endDatetime);
}
