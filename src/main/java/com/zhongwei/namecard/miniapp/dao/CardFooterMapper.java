package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.CardFooter;
import com.zhongwei.namecard.miniapp.model.CardFooterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardFooterMapper {
	
    int countByExample(CardFooterExample example);

    int deleteByExample(CardFooterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardFooter record);

    int insertSelective(CardFooter record);

    List<CardFooter> selectByExample(CardFooterExample example);

    CardFooter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardFooter record, @Param("example") CardFooterExample example);

    int updateByExample(@Param("record") CardFooter record, @Param("example") CardFooterExample example);

    int updateByPrimaryKeySelective(CardFooter record);

    int updateByPrimaryKey(CardFooter record);
}