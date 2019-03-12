package com.zhongwei.namecard.miniapp.dao;

import com.zhongwei.namecard.miniapp.model.CardFriend;
import com.zhongwei.namecard.miniapp.model.CardFriendExample;
import com.zhongwei.namecard.miniapp.model.CardFriendWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CardFriendMapper {
	
    int countByExample(CardFriendExample example);

    int deleteByExample(CardFriendExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardFriendWithBLOBs record);

    int insertSelective(CardFriendWithBLOBs record);

    List<CardFriendWithBLOBs> selectByExampleWithBLOBs(CardFriendExample example);

    List<CardFriend> selectByExample(CardFriendExample example);

    CardFriendWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardFriendWithBLOBs record, @Param("example") CardFriendExample example);

    int updateByExampleWithBLOBs(@Param("record") CardFriendWithBLOBs record, @Param("example") CardFriendExample example);

    int updateByExample(@Param("record") CardFriend record, @Param("example") CardFriendExample example);

    int updateByPrimaryKeySelective(CardFriendWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CardFriendWithBLOBs record);

    int updateByPrimaryKey(CardFriend record);
}