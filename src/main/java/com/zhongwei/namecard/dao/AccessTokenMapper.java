package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.AccessToken;
import com.zhongwei.namecard.entity.AccessTokenExample;

@Mapper
public interface AccessTokenMapper {
	
    int countByExample(AccessTokenExample example);

    int deleteByExample(AccessTokenExample example);

    int deleteByPrimaryKey(String secret);

    int insert(AccessToken record);

    int insertSelective(AccessToken record);

    List<AccessToken> selectByExampleWithBLOBs(AccessTokenExample example);

    List<AccessToken> selectByExample(AccessTokenExample example);

    AccessToken selectByPrimaryKey(String secret);

    int updateByExampleSelective(@Param("record") AccessToken record, @Param("example") AccessTokenExample example);

    int updateByExampleWithBLOBs(@Param("record") AccessToken record, @Param("example") AccessTokenExample example);

    int updateByExample(@Param("record") AccessToken record, @Param("example") AccessTokenExample example);

    int updateByPrimaryKeySelective(AccessToken record);

    int updateByPrimaryKeyWithBLOBs(AccessToken record);

    int updateByPrimaryKey(AccessToken record);
}