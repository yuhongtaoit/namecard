package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.CardNav;
import com.zhongwei.namecard.miniapp.model.CardNavExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardNavMapper {
	
    int countByExample(CardNavExample example);

    int deleteByExample(CardNavExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardNav record);

    int insertSelective(CardNav record);

    List<CardNav> selectByExample(CardNavExample example);

    CardNav selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardNav record, @Param("example") CardNavExample example);

    int updateByExample(@Param("record") CardNav record, @Param("example") CardNavExample example);

    int updateByPrimaryKeySelective(CardNav record);

    int updateByPrimaryKey(CardNav record);
}