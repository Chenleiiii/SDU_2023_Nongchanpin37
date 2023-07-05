package com.qst.crop.dao;

import com.qst.crop.entity.Shoppingcart;
import com.qst.crop.model.ShoppingModel;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public interface ShoppingcartDao {

    int deleteByPrimaryKey(Integer shoppingId);

    int insertSelective(Shoppingcart shoppingcart);

    List<ShoppingModel> selectByShopping(Shoppingcart shoppingcart);

    int updateByPrimaryKeySelective(Shoppingcart shoppingcart);

}