package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardPl;
import com.zhongwei.namecard.entity.CardPlExample;

@Mapper
public interface CardPlMapper {
	
    int countByExample(CardPlExample example);

    int deleteByExample(CardPlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardPl record);

    int insertSelective(CardPl record);

    List<CardPl> selectByExample(CardPlExample example);

    CardPl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardPl record, @Param("example") CardPlExample example);

    int updateByExample(@Param("record") CardPl record, @Param("example") CardPlExample example);

    int updateByPrimaryKeySelective(CardPl record);

    int updateByPrimaryKey(CardPl record);
}