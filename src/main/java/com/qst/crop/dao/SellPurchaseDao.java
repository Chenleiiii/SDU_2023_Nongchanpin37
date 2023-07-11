package com.qst.crop.dao;

import com.qst.crop.entity.SellPurchase;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface SellPurchaseDao {

    int insert(SellPurchase record);

    List<SellPurchase> selectByName(@Param("ownName")String ownName);

}