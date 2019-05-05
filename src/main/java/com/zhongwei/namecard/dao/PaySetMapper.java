package com.zhongwei.namecard.dao;

import com.zhongwei.namecard.entity.PaySet;
import com.zhongwei.namecard.entity.PaySetExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaySetMapper {
    int countByExample(PaySetExample example);

    int deleteByExample(PaySetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaySet record);

    int insertSelective(PaySet record);

    List<PaySet> selectByExample(PaySetExample example);

    PaySet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PaySet record, @Param("example") PaySetExample example);

    int updateByExample(@Param("record") PaySet record, @Param("example") PaySetExample example);

    int updateByPrimaryKeySelective(PaySet record);

    int updateByPrimaryKey(PaySet record);
}