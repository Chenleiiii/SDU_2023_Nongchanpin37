package com.qst.crop.service.impl;

import com.qst.crop.dao.FinanceDao;
import com.qst.crop.entity.*;
import com.qst.crop.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    private FinanceDao financeDao;

    @Override
    public void add(Finance finance) {
        finance.setStatus(0);
        finance.setCreateTime(new Date());
        finance.setUpdateTime(new Date());

        financeDao.insertSelective(finance);
    }

    @Override
    public List<Finance> selectByFinance(Finance finance) {

        List<Finance> finances = financeDao.selectByFinance(finance);
        return finances;
    }

    @Override
    public Finance selectByFinanceId(Integer id){

        Finance finance = financeDao.selectByPrimaryKey(id);
        return finance;
    }

    @Override
    public void deleteByFinanceId(Integer id){

        financeDao.deleteByPrimaryKey(id);
    }

    @Override
    public void updateByFinance(Finance finance){

        finance.setUpdateTime(new Date());
        financeDao.updateByPrimaryKeySelective(finance);

    }

    @Override
    public List<Intention> selectIntentionByName(String name) {
        List<Intention> intentions = financeDao.selectIntentionByName(name);
        return intentions;
    }

    @Override
    public void updateIntentionByName(Intention intention) {
        intention.setUpdateTime(new Date());
        financeDao.updateIntentionByName(intention);
    }

    @Override
    public void insertIntentionByName(Intention intention) {
//        System.out.println("添加融资意向："+intention);
        intention.setCreateTime(new Date());
        intention.setUpdateTime(new Date());
        financeDao.insertIntentionByName(intention);
    }

    @Override
    public void deleteIntentionByName(String name) {
        financeDao.deleteIntentionByName(name);
    }



    @Override
    public List<Recommend> selectRecommend(String name) {
        Intention intention = financeDao.selectIntention(name);
        if(StringUtils.isEmpty(intention)){//无意向
//            System.out.println("无意向");
            List<Recommend> list = financeDao.selectWithNoneIntention(name);
            System.out.println("无意向："+list);
            return list;
        }else {//有意向
//            System.out.println("有意向");
            List<Recommend> list = financeDao.selectAllRecommend(name);
            System.out.println(list);
            return list;
        }


//        Collections.sort(list);
//        list.stream().sorted();
//        System.out.println(list);

    }

    @Override
    public void AuthorizationtoUser(String name, String userName) {
        financeDao.AuthorizationtoUser(name,userName);
    }

    @Override
    public FinaceUserDetails selectFinaceUser(String name,String bankId) {
        FinaceUserDetails user = new FinaceUserDetails();
        Bank bank = financeDao.selectBankById(bankId);
        user.setRate(bank.getRate());
        user.setIntroduce(bank.getIntroduce());
        user.setBankName(bank.getBankName());
        System.out.println("user:"+user.toString());
        return user;
    }

    @Override
    public boolean selectIfApply(String name) {
        Finance finance = financeDao.selectIfApply(name);
        if(StringUtils.isEmpty(finance)){
            return false;
        }
        return true;
    }


    @Override
    public void addMulti(Finance finance) {
        finance.setCreateTime(new Date());
        finance.setUpdateTime(new Date());
        finance.setStatus(0);
//        System.out.println("添加融资情报2:"+finance.toString());
        financeDao.insertMulti(finance);
    }

}
