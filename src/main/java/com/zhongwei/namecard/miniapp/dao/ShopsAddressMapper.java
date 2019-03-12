package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.ShopsAddress;
import com.zhongwei.namecard.miniapp.model.ShopsAddressExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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