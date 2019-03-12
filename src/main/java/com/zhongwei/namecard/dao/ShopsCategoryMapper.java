package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.ShopsCategory;
import com.zhongwei.namecard.entity.ShopsCategoryExample;

@Mapper
public interface ShopsCategoryMapper {
	
    int countByExample(ShopsCategoryExample example);

    int deleteByExample(ShopsCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopsCategory record);

    int insertSelective(ShopsCategory record);

    List<ShopsCategory> selectByExample(ShopsCategoryExample example);

    ShopsCategory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopsCategory record, @Param("example") ShopsCategoryExample example);

    int updateByExample(@Param("record") ShopsCategory record, @Param("example") ShopsCategoryExample example);

    int updateByPrimaryKeySelective(ShopsCategory record);

    int updateByPrimaryKey(ShopsCategory record);
}