package com.qst.crop.dao;

import com.qst.crop.entity.PurchaseDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseDetailDao {

    int insertSelective(PurchaseDetail record);

    List<PurchaseDetail> selectByPurchaseId(@Param("purchaseId")Integer purchaseId);

}