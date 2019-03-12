package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardMember;
import com.zhongwei.namecard.entity.CardMemberExample;

@Mapper
public interface CardMemberMapper {
	
    int countByExample(CardMemberExample example);

    int deleteByExample(CardMemberExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardMember record);

    int insertSelective(CardMember record);

    List<CardMember> selectByExample(CardMemberExample example);

    CardMember selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardMember record, @Param("example") CardMemberExample example);

    int updateByExample(@Param("record") CardMember record, @Param("example") CardMemberExample example);

    int updateByPrimaryKeySelective(CardMember record);

    int updateByPrimaryKey(CardMember record);
}