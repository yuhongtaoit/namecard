package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.CardProduct;
import com.zhongwei.namecard.miniapp.model.CardProductExample;
import com.zhongwei.namecard.miniapp.model.CardProductWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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