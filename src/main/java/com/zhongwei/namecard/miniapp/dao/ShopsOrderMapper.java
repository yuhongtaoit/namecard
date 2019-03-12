package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.ShopsOrder;
import com.zhongwei.namecard.miniapp.model.ShopsOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopsOrderMapper {
	
    int countByExample(ShopsOrderExample example);

    int deleteByExample(ShopsOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopsOrder record);

    int insertSelective(ShopsOrder record);

    List<ShopsOrder> selectByExampleWithBLOBs(ShopsOrderExample example);

    List<ShopsOrder> selectByExample(ShopsOrderExample example);

    ShopsOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopsOrder record, @Param("example") ShopsOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") ShopsOrder record, @Param("example") ShopsOrderExample example);

    int updateByExample(@Param("record") ShopsOrder record, @Param("example") ShopsOrderExample example);

    int updateByPrimaryKeySelective(ShopsOrder record);

    int updateByPrimaryKeyWithBLOBs(ShopsOrder record);

    int updateByPrimaryKey(ShopsOrder record);
}