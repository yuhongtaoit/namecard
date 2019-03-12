package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.ActReport;
import com.zhongwei.namecard.miniapp.model.ActReportExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}