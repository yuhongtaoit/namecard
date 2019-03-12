package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.AuthUser;
import com.zhongwei.namecard.miniapp.model.AuthUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthUserMapper {
	
    int countByExample(AuthUserExample example);

    int deleteByExample(AuthUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuthUser record);

    int insertSelective(AuthUser record);

    List<AuthUser> selectByExample(AuthUserExample example);

    AuthUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    int updateByExample(@Param("record") AuthUser record, @Param("example") AuthUserExample example);

    int updateByPrimaryKeySelective(AuthUser record);

    int updateByPrimaryKey(AuthUser record);
}