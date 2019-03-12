package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.CardForm;
import com.zhongwei.namecard.miniapp.model.CardFormExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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