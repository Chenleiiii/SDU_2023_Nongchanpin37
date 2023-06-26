package com.qst.crop.service.impl;

import com.qst.crop.dao.OrderDao;
import com.qst.crop.dao.UserDao;
import com.qst.crop.entity.Order;
import com.qst.crop.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    //每页显示多条数据
    private  Integer pageSize = 30;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<Order> selectAll(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Order> goods = orderDao.selectAll();
        PageInfo<Order> orderPageInfo = new PageInfo<>(goods);
        return orderPageInfo;
    }

    @Override
    public PageInfo<Order> selectAllGoods(Integer pageNum) {
        Order order = new Order();
        order.setType("goods");
        PageHelper.startPage(pageNum, pageSize);
        List<Order> goods = orderDao.selectAllGoods(order);
        PageInfo<Order> orderPageInfo = new PageInfo<>(goods);
        return orderPageInfo;
    }

    @Override
    public PageInfo<Order> selectAllNeeds(Integer pageNum) {
        Order order = new Order();
        order.setType("needs");

        try{
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Iterator it = principal.getAuthorities().iterator(); // 获得一个迭代子
            while(it.hasNext()) {
                Object obj = it.next(); // 得到下一个元素
                String role = obj.toString();
                if(!role.equals("admin"))
                {
                    order.setOrderStatus(0);
                    break;
                }
            }
        }catch (Exception e){

        }

        PageHelper.startPage(pageNum,pageSize);
        List<Order> orders = orderDao.selectAllNeeds(order);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        return orderPageInfo;
    }

    @Override
    public void add(Order order) {
        String address = userDao.selectAddressByName(order.getOwnName());
        if(!StringUtils.isEmpty(address)){
            order.setAddress(address);
        }
        orderDao.insertSelective(order);
    }

    @Override
    public void update(Order order) {
       orderDao.updateByPrimaryKeySelective(order);
    }

    @Override
    public void delete(Integer id) {
        orderDao.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo<Order> selectByType(String type,Integer pageNum) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        Order order = new Order();
        Iterator it = principal.getAuthorities().iterator(); // 获得一个迭代子
        while(it.hasNext()) {
            Object obj = it.next(); // 得到下一个元素
            String role = obj.toString();
            if(!role.equals("admin"))
            {
                order.setOwnName(name);
                order.setOrderStatus(0);
                break;
            }
        }
        order.setType(type);

        PageHelper.startPage(pageNum, pageSize);
        List<Order> orders = orderDao.selectByExample(order);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);
        return orderPageInfo;
    }


    @Override
    public Order selectById(Integer id) {
        Order order = orderDao.selectByPrimaryKey(id);
        return order;
    }

    @Override
    public PageInfo<Order> selectGoodsByKeys(String keys,Integer pageNum,String name) {
        //创建Order实例
        Order order = new Order();
        order.setType("goods");
        order.setContent(keys);

        try {
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            System.out.println("========="+principal);
            Iterator it = principal.getAuthorities().iterator(); // 获得一个迭代子
            while(it.hasNext()) {
                Object obj = it.next(); // 得到下一个元素
                String role = obj.toString();
                if(!role.equals("admin"))
                {
                    order.setOwnName(name);
                    order.setOrderStatus(0);
                    break;
                }
            }
        }catch (Exception e){

        }


        //分页
        PageHelper.startPage(pageNum, pageSize);
        //查询
        List<Order> orders = orderDao.selectByKeys(order);
        System.out.println(orders);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);

        return orderPageInfo;
    }

    @Override
    public PageInfo<Order> selectNeedsByKeys(String keys,Integer pageNum,String name) {
        //创建Order实例
        Order order = new Order();
        order.setType("needs");
        order.setContent(keys);

        try{
            UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Iterator it = principal.getAuthorities().iterator(); // 获得一个迭代子
            while(it.hasNext()) {
                Object obj = it.next(); // 得到下一个元素
                String role = obj.toString();
                if(!role.equals("admin"))
                {
                    order.setOwnName(name);
                    order.setOrderStatus(0);
                    break;
                }
            }
        }catch (Exception e){

        }


        //分页
        PageHelper.startPage(pageNum, pageSize);
        //查询
        List<Order> orders = orderDao.selectByKeys(order);
        System.out.println(orders);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);

        return orderPageInfo;
    }

    @Override
    public PageInfo<Order> selectAllByKeys(String keys,Integer pageNum) {
        //创建Order实例
        Order order = new Order();
        order.setContent(keys);
        //分页
        PageHelper.startPage(pageNum, pageSize);
        //查询
        List<Order> orders = orderDao.selectByKeys(order);
        PageInfo<Order> orderPageInfo = new PageInfo<>(orders);

        return orderPageInfo;
    }

    @Override
    public void takeDown(String orderId) {
        orderDao.takeDown(orderId);
    }

    @Override
    public void takeUp(String orderId) {
        orderDao.takeUp(orderId);
    }

//    @Override
//    public List<Order> selectBuyByUserName() {
//        //获取登陆的用户名
//        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String name = principal.getUsername();
//        Order order = new Order();
//        order.setCooperationName(name);
//        order.setOrderStatu(1);
//        List<Order> orders = orderDao.selectByExample(order);
//        return orders;
//    }
//
//    @Override
//    public List<Order> selectSellByUserName() {
//        //获取登陆的用户名
//        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String name = principal.getUsername();
//        Order order = new Order();
//        order.setOwnName(name);
//        order.setOrderStatu(1);
//        List<Order> orders = orderDao.selectByExample(order);
//        return orders;
//    }

}
