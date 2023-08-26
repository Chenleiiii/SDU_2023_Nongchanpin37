package com.qst.crop.service.impl;

import com.qst.crop.dao.PurchaseDetailDao;
import com.qst.crop.entity.PurchaseDetail;
import com.qst.crop.service.PurchaseDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseDetailServiceImpl implements PurchaseDetailService {
    @Autowired
    private PurchaseDetailDao purchaseDetailDao;

    @Override
    public void add(PurchaseDetail purchaseDetail) {
        purchaseDetailDao.insertSelective(purchaseDetail);
    }

    @Override
    public List<PurchaseDetail> selectByPurchaseId(Integer purchaseId) {
        List<PurchaseDetail> purchaseDetails = purchaseDetailDao.selectByPurchaseId(purchaseId);
        return purchaseDetails;
    }

}
