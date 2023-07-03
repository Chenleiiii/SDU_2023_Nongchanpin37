package com.qst.crop.service;

import com.qst.crop.entity.*;

import java.util.List;

public interface FinanceService {

    void add(Finance finance);

    List<Finance> selectByFinance(Finance finance);

    Finance selectByFinanceId(Integer id);

    void deleteByFinanceId(Integer id);

    void updateByFinance(Finance finance);

    List<Intention> selectIntentionByName(String name);

    void updateIntentionByName(Intention intention);

    void insertIntentionByName(Intention intention);

    void deleteIntentionByName(String name);

    List<Recommend> selectRecommend(String name);

    void AuthorizationtoUser(String name, String userName);

    FinaceUserDetails selectFinaceUser(String name,String bankId);

    boolean selectIfApply(String name);


    void addMulti(Finance finance);
}
