package com.qst.crop.dao;

import com.qst.crop.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao{

    List<Order> selectAll();

    List<Order> selectByExample(Order order);

    int insertSelective(Order order);

    int updateByPrimaryKeySelective(Order order);

    int deleteByPrimaryKey(Integer id);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectByKeys(Order order);

    void takeDown(String orderId);

    void takeUp(String orderId);

    List<Order> selectAllGoods(Order order);

    List<Order> selectAllNeeds(Order order);
}