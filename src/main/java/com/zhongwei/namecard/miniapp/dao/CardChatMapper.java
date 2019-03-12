package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.CardChat;
import com.zhongwei.namecard.miniapp.model.CardChatExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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