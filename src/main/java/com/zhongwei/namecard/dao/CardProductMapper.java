package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardProduct;
import com.zhongwei.namecard.entity.CardProductExample;
import com.zhongwei.namecard.entity.CardProductWithBLOBs;

@Mapper
public interface CardProductMapper {
	
    int countByExample(CardProductExample example);

    int deleteByExample(CardProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardProductWithBLOBs record);

    int insertSelective(CardProductWithBLOBs record);

    List<CardProductWithBLOBs> selectByExampleWithBLOBs(CardProductExample example);

    List<CardProduct> selectByExample(CardProductExample example);

    CardProductWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardProductWithBLOBs record, @Param("example") CardProductExample example);

    int updateByExampleWithBLOBs(@Param("record") CardProductWithBLOBs record, @Param("example") CardProductExample example);

    int updateByExample(@Param("record") CardProduct record, @Param("example") CardProductExample example);

    int updateByPrimaryKeySelective(CardProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CardProductWithBLOBs record);

    int updateByPrimaryKey(CardProduct record);
}