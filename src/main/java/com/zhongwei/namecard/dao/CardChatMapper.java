package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardChat;
import com.zhongwei.namecard.entity.CardChatExample;

@Mapper
public interface CardChatMapper {
	
    int countByExample(CardChatExample example);

    int deleteByExample(CardChatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardChat record);

    int insertSelective(CardChat record);

    List<CardChat> selectByExample(CardChatExample example);

    CardChat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardChat record, @Param("example") CardChatExample example);

    int updateByExample(@Param("record") CardChat record, @Param("example") CardChatExample example);

    int updateByPrimaryKeySelective(CardChat record);

    int updateByPrimaryKey(CardChat record);
}