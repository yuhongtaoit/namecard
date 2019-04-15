package com.zhongwei.namecard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.ActReport;
import com.zhongwei.namecard.entity.ActReportExample;

@Mapper
public interface ActReportMapper {
	
    int countByExample(ActReportExample example);

    int deleteByExample(ActReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActReport record);

    int insertSelective(ActReport record);

    List<ActReport> selectByExample(ActReportExample example);

    ActReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActReport record, @Param("example") ActReportExample example);

    int updateByExample(@Param("record") ActReport record, @Param("example") ActReportExample example);

    int updateByPrimaryKeySelective(ActReport record);

    int updateByPrimaryKey(ActReport record);
    
    List<Map<String, Object>> selectReportAI(@Param("startTime")String startTime, @Param("endTime")String endTime, 
    		@Param("card_id")int card_id, @Param("uniacid")int uniacid , @Param("openId")String openId);
    
    List<Map<String, Object>> selectReportAct(@Param("startTime")String startTime, @Param("endTime")String endTime, 
    		@Param("card_id")int card_id, @Param("uniacid")int uniacid);
}