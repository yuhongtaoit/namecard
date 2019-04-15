package com.zhongwei.namecard.dao;

import com.zhongwei.namecard.entity.AccountWxapp;
import com.zhongwei.namecard.entity.AccountWxappExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountWxappMapper {
    int countByExample(AccountWxappExample example);

    int deleteByExample(AccountWxappExample example);

    int deleteByPrimaryKey(Integer acid);

    int insert(AccountWxapp record);

    int insertSelective(AccountWxapp record);

    List<AccountWxapp> selectByExample(AccountWxappExample example);

    AccountWxapp selectByPrimaryKey(Integer acid);

    int updateByExampleSelective(@Param("record") AccountWxapp record, @Param("example") AccountWxappExample example);

    int updateByExample(@Param("record") AccountWxapp record, @Param("example") AccountWxappExample example);

    int updateByPrimaryKeySelective(AccountWxapp record);

    int updateByPrimaryKey(AccountWxapp record);
}