package com.qst.crop.dao;

import com.qst.crop.entity.SellPurchase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellPurchaseDao {

    int insertSelective(SellPurchase record);

    List<SellPurchase> selectByName(@Param("ownName")String ownName);

}