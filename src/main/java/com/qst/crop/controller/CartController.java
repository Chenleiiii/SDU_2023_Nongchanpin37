package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.Purchase;
import com.qst.crop.entity.PurchaseDetail;
import com.qst.crop.entity.SellPurchase;
import com.qst.crop.entity.Shoppingcart;
import com.qst.crop.model.ShoppingModel;
import com.qst.crop.service.PurchaseDetailService;
import com.qst.crop.service.PurchaseService;
import com.qst.crop.service.SellPurchaseService;
import com.qst.crop.service.ShoppingcartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author QST
 * @Description 购物车
 * @Date 2021-08-24
 */
@RestController
@RequestMapping("/cart")
@Api(tags = "购物车接口")
public class CartController {
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private ShoppingcartService shoppingcartService;
    @Autowired
    private PurchaseDetailService purchaseDetailService;
    @Autowired
    private SellPurchaseService sellPurchaseService;

    //添加商品到购物车
    @ApiOperation("添加商品到购物车")
    @PostMapping("/add/{id}")
    public Result add(@PathVariable("id") Integer id) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        Shoppingcart shoppingcart =new Shoppingcart();
        shoppingcart.setOwnName(name);
        shoppingcart.setOrderId(id);
        shoppingcart.setCount(1);
        shoppingcart.setCreateTime(new Date());
        shoppingcart.setUpdateTime(new Date());

        List<ShoppingModel> shoppingcarts = shoppingcartService.selectByUserOrderId(id);
        if (null!= shoppingcarts && shoppingcarts.size() > 0){
            shoppingcart.setCount(shoppingcarts.get(0).getCount() + 1);
            shoppingcart.setShoppingId(shoppingcarts.get(0).getShoppingId());
            shoppingcartService.update(shoppingcart);
        }
        else {
            shoppingcartService.add(shoppingcart);
        }
        return new Result(true, StatusCode.OK, "添加商品到购物车成功");
    }

    //从购物车删除商品
    @ApiOperation("从购物车删除商品")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        //获取登陆的用户名
        shoppingcartService.delete(id);
        return new Result(true, StatusCode.OK, "删除商品成功");
    }

    //展示购物车列表
    @ApiOperation("展示购物车列表")
    @GetMapping("/show")
    public Result<List<ShoppingModel>> show() {

        List<ShoppingModel> shoppingModel = shoppingcartService.selectByUsername();

        return new Result<List<ShoppingModel>>(true, StatusCode.OK, "查询成功", shoppingModel);
    }

    //更新购物车数量
    @ApiOperation("更新购物车数量")
    @PutMapping("/update/{id}/{count}")
    public Result update(@PathVariable("id") Integer id,@PathVariable("count") Integer count) {

        //创建实例Shoppingcart，设置id,数量，更新日期
        Shoppingcart shoppingcart =new Shoppingcart();
        shoppingcart.setShoppingId(id);
        shoppingcart.setCount(count);
        shoppingcart.setUpdateTime(new Date());
        //更新
        shoppingcartService.update(shoppingcart);
        return new Result(true, StatusCode.OK, "更新商品数量成功");
    }

    //提交订单
    @ApiOperation("提交订单")
    @PostMapping("/commitOrder/{addId}/{tMoney}")
    public Result commitOrder(@PathVariable("addId") Integer addId,@PathVariable("tMoney") String tMoney,@RequestBody List<ShoppingModel> shoppingModelList) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();

        //添加购买人买入订单
        //创建Purchase实例，设置订单类型为
        Purchase purchase = new Purchase();
        purchase.setPurchaseType(1);//买入商品
        purchase.setOwnName(name);
        purchase.setAddress(addId.toString());
        purchase.setPurchaseStatus(1);//状态统一为待发货
        purchase.setTotalPrice(new BigDecimal(tMoney));
        purchase.setCreateTime(new Date());
        purchase.setUpdateTime(new Date());

        purchaseService.add(purchase);
        //取得刚才插入订单的id
        Purchase PurchaseGetId = purchaseService.selectNewPurchaseId(name);
        Integer purchaseId = PurchaseGetId.getPurchaseId();
        //添加购买人买入订单详细
        if (null != shoppingModelList && shoppingModelList.size() > 0){
            PurchaseDetail purchaseDetail = new PurchaseDetail();
            SellPurchase sellPurchase = new SellPurchase();
            for (int i = 0; i<shoppingModelList.size(); i++){
                ShoppingModel shoppingModel = shoppingModelList.get(i);
                purchaseDetail.setCount(shoppingModel.getCount());
                purchaseDetail.setOrderId(shoppingModel.getOrderId());
                purchaseDetail.setPurchaseId(purchaseId);
                purchaseDetail.setSumPrice(new BigDecimal(Double.parseDouble(shoppingModel.getPrice())* shoppingModel.getCount()));
                purchaseDetail.setUninPrice(new BigDecimal(shoppingModel.getPrice()));
                purchaseDetailService.add(purchaseDetail);

                //卖出订单
                //添加卖出方卖出订单
                //创建Purchase实例，设置订单类型为
                sellPurchase.setOrderId(shoppingModel.getOrderId());
                sellPurchase.setAddress(addId.toString());
                sellPurchase.setOwnName(shoppingModel.getOwnName());
                sellPurchase.setPurchaseId(purchaseId);
                sellPurchase.setPurchaseStatus(1);
                sellPurchase.setPurchaseType(2);
                sellPurchase.setSumPrice(new BigDecimal(Double.parseDouble(shoppingModel.getPrice())* shoppingModel.getCount()));
                sellPurchase.setUninPricee(new BigDecimal(shoppingModel.getPrice()));
                sellPurchase.setCreateTime(new Date());
                sellPurchase.setUpdateTime(new Date());
                sellPurchaseService.add(sellPurchase);

                //删除购物车信息
                shoppingcartService.delete(shoppingModel.getShoppingId());
            }
        }

        return new Result(true, StatusCode.OK, "提交成功");
    }
}