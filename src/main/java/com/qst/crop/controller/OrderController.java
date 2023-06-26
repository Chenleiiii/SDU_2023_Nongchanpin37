package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.Order;
import com.qst.crop.entity.Purchase;
import com.qst.crop.entity.PurchaseDetail;
import com.qst.crop.entity.SellPurchase;
import com.qst.crop.model.MyPurchase;
import com.qst.crop.service.OrderService;
import com.qst.crop.service.PurchaseDetailService;
import com.qst.crop.service.PurchaseService;
import com.github.pagehelper.PageInfo;
import com.qst.crop.service.SellPurchaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * @author QST
 * @Description 订单模块
 * @Date 2021-08-24
 */
@Api(tags = "订单模块接口")
@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private PurchaseDetailService purchaseDetailService;

    @Autowired
    private SellPurchaseService sellPurchaseService;

    //查询所有商品
    @ApiOperation(value = "查询所有商品")
    @GetMapping("/All/{pageNum}")
    public Result<PageInfo> selectAll(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectAll(pageNum);
//        System.out.println("总记录数："+orders.getTotal());
//        System.out.println("总页数："+orders.getPages());
//        System.out.println("一页的大小："+orders.getSize());
//        System.out.println(orders);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //查询所有商品（货源)商品
    @ApiOperation(value = "分页查询所有货源(商品)商品")
    @GetMapping("/goods/{pageNum}")
    public Result<PageInfo> selectAllGoods(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectAllGoods(pageNum);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //查询所有需求
    @ApiOperation(value = "分页查询所有需求")
    @GetMapping("/needs/{pageNum}")
    public Result<PageInfo> selectAllNeeds(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectAllNeeds(pageNum);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //添加订单
    @ApiOperation(value = "添加商品")
    @PostMapping
    public Result<String> add(@Valid @RequestBody Order order, BindingResult bindingResult) {
        //检查项目
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage()).append("; ");
            }
            String s = stringBuffer.toString();
            System.out.println(s);
            return new Result<String>(false, StatusCode.ERROR, "添加失败",s);
        }
        //获取用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        order.setOwnName(name);
        //设置时间
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        //添加
        orderService.add(order);
        return new Result(true, StatusCode.OK, "添加成功",null);
    }

    //修改id订单
    @ApiOperation(value = "根据id修改商品")
    @PutMapping("/{id}")
    public Result<String> update(@Validated @RequestBody Order order,BindingResult bindingResult,
                         @PathVariable Integer id) {
        //检查项目
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage()).append("; ");
            }
            String s = stringBuffer.toString();
            System.out.println(s);
            return new Result<String>(false, StatusCode.ERROR, "修改失败",s);
        }
        order.setUpdateTime(new Date());
        order.setOrderId(id);
        orderService.update(order);
        return new Result(true, StatusCode.OK, "修改成功",null);
    }

    //删除订单
    @ApiOperation(value = "根据id删除商品")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        orderService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //根据用户名+类型查询商品
    @ApiOperation(value = "根据用户名+订单类型查询商品")
    @GetMapping("/search/{type}/{pageNum}")
    public Result<PageInfo> selectByType(@PathVariable("type") String type,@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectByType(type,pageNum);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //根据id查询商品
    @ApiOperation(value = "根据id查询商品")
    @GetMapping("/selectById/{id}")
    public Result<Order> selectById(@PathVariable("id") Integer id) {
        Order order = orderService.selectById(id);
        return new Result<Order>(true, StatusCode.OK, "查询成功", order);

    }

    //根据登录用户查询我买的订单
    @ApiOperation(value = "根据登录用户查询我买的订单")
    @GetMapping("/selectBuys")
    public Result<List<MyPurchase>> selectBuys() {
        List<MyPurchase> purchase = purchaseService.selectByPurchaseType();
        return new Result<List<MyPurchase>>(true, StatusCode.OK, "查询成功", purchase);

    }

    //根据登录用户查询我买的订单详情
    @ApiOperation(value = "根据登录用户查询我买的订单详情")
    @GetMapping("/selectBuysDetail/{id}")
    public Result<List<PurchaseDetail>> selectBuysDetail(@PathVariable("id") Integer purchaseId) {
        List<PurchaseDetail> purchaseDetail = purchaseDetailService.selectByPurchaseId(purchaseId);
        return new Result<List<PurchaseDetail>>(true, StatusCode.OK, "查询成功", purchaseDetail);
    }

    //根据登录用户查询我卖出的订单
    @ApiOperation(value = "根据登录用户查询我卖出的订单")
    @GetMapping("/selectSells")
    public Result<List<SellPurchase>> selectSells() {
        List<SellPurchase> purchase = sellPurchaseService.selectByName();
        return new Result<List<SellPurchase>>(true, StatusCode.OK, "查询成功", purchase);

    }

    //分页条件搜索商品（货源）商品
    @ApiOperation(value = "分页条件搜索商品（货源）订单")
    @GetMapping("/searchGoodsByKeys/{keys}/{pageNum}")
    public Result<PageInfo> searchGoodsByKeys(@PathVariable("keys") String keys,@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectGoodsByKeys(keys,pageNum,null);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //分页条件搜索需求商品
    @ApiOperation(value = "分页条件搜索需求商品")
    @GetMapping("/searchNeedsByKeys/{keys}/{pageNum}")
    public Result<PageInfo> searchNeedsByKeys(@PathVariable("keys") String keys,@PathVariable("pageNum") Integer pageNum) {
            PageInfo<Order> orders = orderService.selectNeedsByKeys(keys,pageNum,null);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //分页条件搜索所有商品
    @ApiOperation(value = "分页条件搜索所有商品")
    @GetMapping("/searchAllByKeys/{keys}/{pageNum}")
    public Result<PageInfo> searchAllByKeys(@PathVariable("keys") String keys,@PathVariable("pageNum") Integer pageNum) {
        PageInfo<Order> orders = orderService.selectAllByKeys(keys,pageNum);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //分页条件搜索需求商品
    @ApiOperation(value = "分页条件搜索需求商品")
    @GetMapping("/searchMyNeedsByKeys/{keys}/{pageNum}")
    public Result<PageInfo> searchMyNeedsByKeys(@PathVariable("keys") String keys,@PathVariable("pageNum") Integer pageNum) {

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();

        PageInfo<Order> orders = orderService.selectNeedsByKeys(keys,pageNum,name);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }

    //分页条件搜索商品（货源）商品
    @ApiOperation(value = "分页条件搜索商品（货源）商品")
    @GetMapping("/searchMyGoodsByKeys/{keys}/{pageNum}")
    public Result<PageInfo> searchMyGoodsByKeys(@PathVariable("keys") String keys,@PathVariable("pageNum") Integer pageNum) {

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();

        PageInfo<Order> orders = orderService.selectGoodsByKeys(keys,pageNum,name);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", orders);
    }
    //商品下架
    @ApiOperation(value = "商品下架")
    @PutMapping("/takeDownOrder/{orderId}")
    public Result takeDownOrder(@PathVariable("orderId") String orderId) {
        orderService.takeDown(orderId);
        return new Result<PageInfo>(true, StatusCode.OK, "下架成功");
    }
    //商品上架
    @ApiOperation(value = "商品上架")
    @PutMapping("/takeUpOrder/{orderId}")
    public Result takeUpOrder(@PathVariable("orderId") String orderId) {
        orderService.takeUp(orderId);
        return new Result<PageInfo>(true, StatusCode.OK, "上架成功");
    }

}
