package com.qst.crop.service.impl;

import com.qst.crop.dao.PurchaseDao;
import com.qst.crop.entity.Purchase;
import com.qst.crop.entity.Shoppingcart;
import com.qst.crop.model.MyPurchase;
import com.qst.crop.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;

    @Override
    public void add(Purchase purchase) {
        purchaseDao.insertSelective(purchase);
    }

    @Override
    public List<MyPurchase> selectByPurchaseType() {

        //获取用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        //创建Purchase实例，设置用户名，订单类型
//        Purchase purchase= new Purchase();
//        MyPurchase purchase = new MyPurchase();
//        purchase.setOwnName(name);
        System.out.println("查询订单：");
        //查询
        List<MyPurchase> purchases = purchaseDao.selectByPurchase(name);
        System.out.println(purchases);

        return purchases;
    }

    @Override
    public Purchase selectNewPurchaseId(String ownName) {
        Purchase purchase = purchaseDao.selectNewPurchaseId(ownName);
        return purchase;
    }
}
