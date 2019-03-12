package com.zhongwei.namecard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.zhongwei.namecard.entity.ShopsAddress;
import com.zhongwei.namecard.entity.ShopsAddressExample;

@Mapper
public interface ShopsAddressMapper {

    int countByExample(ShopsAddressExample example);

    int deleteByExample(ShopsAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopsAddress record);

    int insertSelective(ShopsAddress record);

    List<ShopsAddress> selectByExampleWithBLOBs(ShopsAddressExample example);

    List<ShopsAddress> selectByExample(ShopsAddressExample example);

    ShopsAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopsAddress record, @Param("example") ShopsAddressExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopsAddress record, @Param("example") ShopsAddressExample example);

    int updateByExample(@Param("record") ShopsAddress record, @Param("example") ShopsAddressExample example);

    int updateByPrimaryKeySelective(ShopsAddress record);

    int updateByPrimaryKeyWithBLOBs(ShopsAddress record);

    int updateByPrimaryKey(ShopsAddress record);
}