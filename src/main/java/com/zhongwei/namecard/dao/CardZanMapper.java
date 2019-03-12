package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardZan;
import com.zhongwei.namecard.entity.CardZanExample;

@Mapper
public interface CardZanMapper {
	
    int countByExample(CardZanExample example);

    int deleteByExample(CardZanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardZan record);

    int insertSelective(CardZan record);

    List<CardZan> selectByExample(CardZanExample example);

    CardZan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardZan record, @Param("example") CardZanExample example);

    int updateByExample(@Param("record") CardZan record, @Param("example") CardZanExample example);

    int updateByPrimaryKeySelective(CardZan record);

    int updateByPrimaryKey(CardZan record);
}