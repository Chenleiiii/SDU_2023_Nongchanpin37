package com.qst.crop.dao;

import com.qst.crop.entity.Bank;
import com.qst.crop.entity.Finance;
import com.qst.crop.entity.Intention;
import com.qst.crop.entity.Recommend;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface FinanceDao {

    int deleteByPrimaryKey(Integer financeId);

    int insertSelective(Finance record);

    Finance selectByPrimaryKey(Integer financeId);

    List<Finance> selectByFinance(Finance finance);

    int updateByPrimaryKeySelective(Finance record);

    List<Intention> selectIntentionByName(String name);

    void updateIntentionByName(Intention intention);

    void insertIntentionByName(Intention intention);

    void deleteIntentionByName(String name);

//    List<Recommend> selectRecommendByName(String name);

    String selectAvatarByName(String userName);

    List<String> selectItems(String userName);

    List<Recommend> selectRecommend(@Param("name") String name,@Param("product") String product);

    String selectIntentionProductByName(String name);

    List<String> selectAllProductByName(String name);

    void AuthorizationtoUser(@Param("name") String name,@Param("userName") String userName);

    int selectAmountByName(String name);

    BigDecimal selectMoneyByBankId(String bankId);

    Bank selectBankById(String bankId);

    Intention selectIntention(String name);


    Finance selectIfApply(String name);

    List<String> selectPhoneAddressByName(String name);

    String selectNameByAuth(String name);

    void insertMulti(Finance finance);

    List<Recommend> selectAllRecommend(String name);

    List<Recommend> selectWithNoneIntention(String name);
}