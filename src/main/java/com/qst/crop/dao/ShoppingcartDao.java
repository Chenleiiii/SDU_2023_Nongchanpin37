package com.qst.crop.dao;

import com.qst.crop.entity.Shoppingcart;
import com.qst.crop.model.ShoppingModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface ShoppingcartDao {

    int delete(Integer shoppingId);

    int insert(Shoppingcart shoppingcart);

    List<ShoppingModel> selectByCart(Shoppingcart shoppingcart);

    int updateById(Shoppingcart shoppingcart);

}