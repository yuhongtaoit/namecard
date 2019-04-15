package com.zhongwei.namecard.dao;

import com.zhongwei.namecard.entity.CardCloser;
import com.zhongwei.namecard.entity.CardCloserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardCloserMapper {
    int countByExample(CardCloserExample example);

    int deleteByExample(CardCloserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardCloser record);

    int insertSelective(CardCloser record);

    List<CardCloser> selectByExampleWithBLOBs(CardCloserExample example);

    List<CardCloser> selectByExample(CardCloserExample example);

    CardCloser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardCloser record, @Param("example") CardCloserExample example);

    int updateByExampleWithBLOBs(@Param("record") CardCloser record, @Param("example") CardCloserExample example);

    int updateByExample(@Param("record") CardCloser record, @Param("example") CardCloserExample example);

    int updateByPrimaryKeySelective(CardCloser record);

    int updateByPrimaryKeyWithBLOBs(CardCloser record);

    int updateByPrimaryKey(CardCloser record);
}