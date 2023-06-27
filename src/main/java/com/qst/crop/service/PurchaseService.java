package com.qst.crop.service;

import com.qst.crop.entity.Purchase;
import com.qst.crop.entity.Shoppingcart;
import com.qst.crop.model.MyPurchase;

import java.util.List;

public interface PurchaseService {

    void add(Purchase purchase);

    List<MyPurchase> selectByPurchaseType();

    Purchase selectNewPurchaseId(String ownName);

}
