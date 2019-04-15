package com.zhongwei.namecard.dao;

import com.zhongwei.namecard.entity.SetFx;
import com.zhongwei.namecard.entity.SetFxExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SetFxMapper {
    int countByExample(SetFxExample example);

    int deleteByExample(SetFxExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SetFx record);

    int insertSelective(SetFx record);

    List<SetFx> selectByExample(SetFxExample example);

    SetFx selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SetFx record, @Param("example") SetFxExample example);

    int updateByExample(@Param("record") SetFx record, @Param("example") SetFxExample example);

    int updateByPrimaryKeySelective(SetFx record);

    int updateByPrimaryKey(SetFx record);
}