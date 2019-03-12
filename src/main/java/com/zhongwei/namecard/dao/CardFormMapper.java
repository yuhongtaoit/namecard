package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardForm;
import com.zhongwei.namecard.entity.CardFormExample;

@Mapper
public interface CardFormMapper {
	
    int countByExample(CardFormExample example);

    int deleteByExample(CardFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardForm record);

    int insertSelective(CardForm record);

    List<CardForm> selectByExample(CardFormExample example);

    CardForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardForm record, @Param("example") CardFormExample example);

    int updateByExample(@Param("record") CardForm record, @Param("example") CardFormExample example);

    int updateByPrimaryKeySelective(CardForm record);

    int updateByPrimaryKey(CardForm record);
}