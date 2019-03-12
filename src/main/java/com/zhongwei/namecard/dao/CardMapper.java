package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.Card;
import com.zhongwei.namecard.entity.CardExample;
import com.zhongwei.namecard.entity.CardWithBLOBs;

@Mapper
public interface CardMapper {
	
    int countByExample(CardExample example);

    int deleteByExample(CardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardWithBLOBs record);

    int insertSelective(CardWithBLOBs record);

    List<CardWithBLOBs> selectByExampleWithBLOBs(CardExample example);

    List<Card> selectByExample(CardExample example);

    CardWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardWithBLOBs record, @Param("example") CardExample example);

    int updateByExampleWithBLOBs(@Param("record") CardWithBLOBs record, @Param("example") CardExample example);

    int updateByExample(@Param("record") Card record, @Param("example") CardExample example);

    int updateByPrimaryKeySelective(CardWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CardWithBLOBs record);

    int updateByPrimaryKey(Card record);
}