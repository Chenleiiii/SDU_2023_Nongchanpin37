package com.qst.crop.service;

import com.qst.crop.entity.Order;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface OrderService {
    PageInfo<Order> selectAll(Integer pageNum);

    PageInfo<Order> selectAllGoods(Integer pageNum);

    PageInfo<Order> selectAllNeeds(Integer pageNum);

    void add(Order order);

    void update(Order order);

    void delete(Integer id);

    PageInfo<Order> selectByType(String type, Integer pageNum);

    Order selectById(Integer id);

    PageInfo<Order> selectGoodsByKeys(String keys,Integer pageNum,String name);

    PageInfo<Order> selectNeedsByKeys(String keys,Integer pageNum,String name);

    PageInfo<Order> selectAllByKeys(String keys,Integer pageNum);

    void takeDown(String orderId);

    void takeUp(String orderId);
}
