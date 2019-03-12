package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.ShopsCategory;
import com.zhongwei.namecard.miniapp.model.ShopsCategoryExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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