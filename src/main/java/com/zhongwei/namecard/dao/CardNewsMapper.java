package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardNews;
import com.zhongwei.namecard.entity.CardNewsExample;

@Mapper
public interface CardNewsMapper {
	
    int countByExample(CardNewsExample example);

    int deleteByExample(CardNewsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardNews record);

    int insertSelective(CardNews record);

    List<CardNews> selectByExampleWithBLOBs(CardNewsExample example);

    List<CardNews> selectByExample(CardNewsExample example);

    CardNews selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardNews record, @Param("example") CardNewsExample example);

    int updateByExampleWithBLOBs(@Param("record") CardNews record, @Param("example") CardNewsExample example);

    int updateByExample(@Param("record") CardNews record, @Param("example") CardNewsExample example);

    int updateByPrimaryKeySelective(CardNews record);

    int updateByPrimaryKeyWithBLOBs(CardNews record);

    int updateByPrimaryKey(CardNews record);
}