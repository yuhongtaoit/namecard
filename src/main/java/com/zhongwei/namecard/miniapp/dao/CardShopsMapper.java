package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.CardShops;
import com.zhongwei.namecard.miniapp.model.CardShopsExample;
import com.zhongwei.namecard.miniapp.model.CardShopsWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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