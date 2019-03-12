package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.SetQY;
import com.zhongwei.namecard.entity.SetQYExample;

@Mapper
public interface SetQYMapper {
	
    int countByExample(SetQYExample example);

    int deleteByExample(SetQYExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SetQY record);

    int insertSelective(SetQY record);

    List<SetQY> selectByExample(SetQYExample example);

    SetQY selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SetQY record, @Param("example") SetQYExample example);

    int updateByExample(@Param("record") SetQY record, @Param("example") SetQYExample example);

    int updateByPrimaryKeySelective(SetQY record);

    int updateByPrimaryKey(SetQY record);
}