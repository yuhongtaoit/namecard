package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.SetQY;
import com.zhongwei.namecard.miniapp.model.SetQYExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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