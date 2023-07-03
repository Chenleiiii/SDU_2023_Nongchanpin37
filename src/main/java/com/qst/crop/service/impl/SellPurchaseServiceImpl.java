package com.qst.crop.service.impl;

import com.qst.crop.dao.SellPurchaseDao;
import com.qst.crop.entity.SellPurchase;
import com.qst.crop.service.SellPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SellPurchaseServiceImpl implements SellPurchaseService {
    @Autowired
    private SellPurchaseDao sellPurchaseDao;

    @Override
    public void add(SellPurchase sellPurchase) {
        sellPurchaseDao.insertSelective(sellPurchase);
    }

    @Override
    public List<SellPurchase> selectByName(){
        //获取用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();

        return sellPurchaseDao.selectByName(name);
    }
}
