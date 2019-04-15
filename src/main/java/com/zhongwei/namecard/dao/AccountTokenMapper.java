package com.zhongwei.namecard.dao;

import com.zhongwei.namecard.entity.AccountToken;
import com.zhongwei.namecard.entity.AccountTokenExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountTokenMapper {
    int countByExample(AccountTokenExample example);

    int deleteByExample(AccountTokenExample example);

    int deleteByPrimaryKey(String secret);

    int insert(AccountToken record);

    int insertSelective(AccountToken record);

    List<AccountToken> selectByExampleWithBLOBs(AccountTokenExample example);

    List<AccountToken> selectByExample(AccountTokenExample example);

    AccountToken selectByPrimaryKey(String secret);

    int updateByExampleSelective(@Param("record") AccountToken record, @Param("example") AccountTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") AccountToken record, @Param("example") AccountTokenExample example);

    int updateByExample(@Param("record") AccountToken record, @Param("example") AccountTokenExample example);

    int updateByPrimaryKeySelective(AccountToken record);

    int updateByPrimaryKeyWithBLOBs(AccountToken record);

    int updateByPrimaryKey(AccountToken record);
}