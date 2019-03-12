package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.ShopsSpec;
import com.zhongwei.namecard.miniapp.model.ShopsSpecExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopsSpecMapper {
	
    int countByExample(ShopsSpecExample example);

    int deleteByExample(ShopsSpecExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopsSpec record);

    int insertSelective(ShopsSpec record);

    List<ShopsSpec> selectByExampleWithBLOBs(ShopsSpecExample example);

    List<ShopsSpec> selectByExample(ShopsSpecExample example);

    ShopsSpec selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopsSpec record, @Param("example") ShopsSpecExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopsSpec record, @Param("example") ShopsSpecExample example);

    int updateByExample(@Param("record") ShopsSpec record, @Param("example") ShopsSpecExample example);

    int updateByPrimaryKeySelective(ShopsSpec record);

    int updateByPrimaryKeyWithBLOBs(ShopsSpec record);

    int updateByPrimaryKey(ShopsSpec record);
}