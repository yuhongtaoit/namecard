package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardWeb;
import com.zhongwei.namecard.entity.CardWebExample;

@Mapper
public interface CardWebMapper {
	
    int countByExample(CardWebExample example);

    int deleteByExample(CardWebExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardWeb record);

    int insertSelective(CardWeb record);

    List<CardWeb> selectByExampleWithBLOBs(CardWebExample example);

    List<CardWeb> selectByExample(CardWebExample example);

    CardWeb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardWeb record, @Param("example") CardWebExample example);

    int updateByExampleWithBLOBs(@Param("record") CardWeb record, @Param("example") CardWebExample example);

    int updateByExample(@Param("record") CardWeb record, @Param("example") CardWebExample example);

    int updateByPrimaryKeySelective(CardWeb record);

    int updateByPrimaryKeyWithBLOBs(CardWeb record);

    int updateByPrimaryKey(CardWeb record);
}