package com.qst.crop.service;

import com.qst.crop.entity.PurchaseDetail;

import java.util.List;

public interface PurchaseDetailService {

    void add(PurchaseDetail purchaseDetail);

    List<PurchaseDetail> selectByPurchaseId(Integer purchaseId);

}
