package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.CardShops;
import com.zhongwei.namecard.entity.CardShopsExample;
import com.zhongwei.namecard.entity.CardShopsWithBLOBs;

@Mapper
public interface CardShopsMapper {
	
    int countByExample(CardShopsExample example);

    int deleteByExample(CardShopsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardShopsWithBLOBs record);

    int insertSelective(CardShopsWithBLOBs record);

    List<CardShopsWithBLOBs> selectByExampleWithBLOBs(CardShopsExample example);

    List<CardShops> selectByExample(CardShopsExample example);

    CardShopsWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardShopsWithBLOBs record, @Param("example") CardShopsExample example);

    int updateByExampleWithBLOBs(@Param("record") CardShopsWithBLOBs record, @Param("example") CardShopsExample example);

    int updateByExample(@Param("record") CardShops record, @Param("example") CardShopsExample example);

    int updateByPrimaryKeySelective(CardShopsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CardShopsWithBLOBs record);

    int updateByPrimaryKey(CardShops record);
}