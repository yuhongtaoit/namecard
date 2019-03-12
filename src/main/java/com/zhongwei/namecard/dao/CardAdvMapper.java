package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardAdv;
import com.zhongwei.namecard.entity.CardAdvExample;

@Mapper
public interface CardAdvMapper {
	
    int countByExample(CardAdvExample example);

    int deleteByExample(CardAdvExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardAdv record);

    int insertSelective(CardAdv record);

    List<CardAdv> selectByExample(CardAdvExample example);

    CardAdv selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardAdv record, @Param("example") CardAdvExample example);

    int updateByExample(@Param("record") CardAdv record, @Param("example") CardAdvExample example);

    int updateByPrimaryKeySelective(CardAdv record);

    int updateByPrimaryKey(CardAdv record);
}