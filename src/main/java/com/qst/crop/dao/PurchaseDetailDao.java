package com.qst.crop.dao;

import com.qst.crop.entity.PurchaseDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface PurchaseDetailDao {

    int insert(PurchaseDetail record);

    List<PurchaseDetail> selectByPurchaseId(@Param("purchaseId")Integer purchaseId);

}