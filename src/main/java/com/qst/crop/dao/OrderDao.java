package com.qst.crop.dao;

import com.qst.crop.entity.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface OrderDao{

    List<Order> selectAll();

    List<Order> selectByOrder(Order order);

    int insert(Order order);

    int updateById(Order order);

    int delete(Integer id);

    Order selectById(Integer id);

    List<Order> selectByKeys(Order order);

    void takeDown(String orderId);

    void takeUp(String orderId);

    List<Order> selectAllGoods(Order order);

    List<Order> selectAllNeeds(Order order);
}