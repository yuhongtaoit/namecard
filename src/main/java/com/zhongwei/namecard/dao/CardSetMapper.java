package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardSet;
import com.zhongwei.namecard.entity.CardSetExample;

@Mapper
public interface CardSetMapper {
	
    int countByExample(CardSetExample example);

    int deleteByExample(CardSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardSet record);

    int insertSelective(CardSet record);

    List<CardSet> selectByExample(CardSetExample example);

    CardSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardSet record, @Param("example") CardSetExample example);

    int updateByExample(@Param("record") CardSet record, @Param("example") CardSetExample example);

    int updateByPrimaryKeySelective(CardSet record);

    int updateByPrimaryKey(CardSet record);
}