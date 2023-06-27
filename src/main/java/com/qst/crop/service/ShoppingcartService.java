package com.qst.crop.service;

import com.qst.crop.entity.Shoppingcart;
import com.qst.crop.model.ShoppingModel;

import java.util.List;

public interface ShoppingcartService {

    void add(Shoppingcart shoppingcart);

    void update(Shoppingcart shoppingcart);

    void delete(Integer id);

    List<ShoppingModel> selectByUsername();

    List<ShoppingModel> selectByUserOrderId(Integer orderId);

}
