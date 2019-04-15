package com.zhongwei.namecard.dao;

import com.zhongwei.namecard.entity.CardTicket;
import com.zhongwei.namecard.entity.CardTicketExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardTicketMapper {
    int countByExample(CardTicketExample example);

    int deleteByExample(CardTicketExample example);

    int deleteByPrimaryKey(String accessToken);

    int insert(CardTicket record);

    int insertSelective(CardTicket record);

    List<CardTicket> selectByExampleWithBLOBs(CardTicketExample example);

    List<CardTicket> selectByExample(CardTicketExample example);

    CardTicket selectByPrimaryKey(String accessToken);

    int updateByExampleSelective(@Param("record") CardTicket record, @Param("example") CardTicketExample example);

    int updateByExampleWithBLOBs(@Param("record") CardTicket record, @Param("example") CardTicketExample example);

    int updateByExample(@Param("record") CardTicket record, @Param("example") CardTicketExample example);

    int updateByPrimaryKeySelective(CardTicket record);

    int updateByPrimaryKeyWithBLOBs(CardTicket record);

    int updateByPrimaryKey(CardTicket record);
}