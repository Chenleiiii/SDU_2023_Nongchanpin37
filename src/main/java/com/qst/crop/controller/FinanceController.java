package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.*;
import com.qst.crop.service.BankService;
import com.qst.crop.service.FinanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author QST
 * @Description 融资模块
 * @Date 2021-08-24
 */
@Api(tags = "融资模块接口")
@RestController
@RequestMapping("/finance")
@CrossOrigin
public class FinanceController {
    @Autowired
    private FinanceService financeService;
    @Autowired
    private BankService bankService;

    //查询融资意向
    @ApiOperation(value = "查询融资意向")
    @GetMapping("/selectIntentionByName")
    public Result selectIntentionByName(){
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        List<Intention> intentions = financeService.selectIntentionByName(name);
        return new Result(true, StatusCode.OK, "查询成功", intentions);
    }
    //添加融资意向
    @ApiOperation(value = "添加融资意向")
    @PostMapping("/insertIntentionByName")
    public Result insertIntentionByName(@RequestBody Intention intention){
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        intention.setUserName(name);
        financeService.insertIntentionByName(intention);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    //修改融资意向
    @ApiOperation(value = "修改融资意向")
    @PutMapping("/updateIntentionByName")
    public Result updateIntentionByName(@RequestBody Intention intention){
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        intention.setUserName(name);
//        System.out.println("修改融资");
//        System.out.println(intention);
        financeService.updateIntentionByName(intention);
        return new Result(true, StatusCode.OK, "修改成功");
    }
    //删除融资意向
    @ApiOperation(value = "删除融资意向")
    @DeleteMapping("/deleteIntentionByName")
    public Result deleteIntentionByName(){
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        financeService.deleteIntentionByName(name);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //查询推荐融资人
    @ApiOperation(value = "查询推荐融资人")
    @GetMapping("/selectRecommendByName")
    public Result selectRecommendByName(){
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        List<Recommend> list = financeService.selectRecommend(name);

        return new Result(true, StatusCode.OK, "查询成功",list);
    }

    //单人贷款
    @ApiOperation(value = "单人贷款")
    @GetMapping("/selectFinaceUser/{bankId}")
    public Result selectFinaceUser(@PathVariable("bankId") String bankId){
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
//        System.out.println("bankId:"+bankId);
        FinaceUserDetails finaceUserDetails = financeService.selectFinaceUser(name,bankId);

        return new Result(true, StatusCode.OK, null,finaceUserDetails);
    }

    //查询是否已经贷款
    @ApiOperation(value = "查询是否已经贷款")
    @GetMapping("/selectIfApply")
    public Result selectIfApply() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
//        System.out.println("查询是否已经贷款:"+name);
        boolean b = financeService.selectIfApply(name);
        return new Result(true, StatusCode.OK, "添加成功",b);
    }

    //添加单人贷款
    @ApiOperation(value = "添加单人贷款")
    @PostMapping("/add")
    public Result add(@RequestBody Finance finance) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        finance.setOwnName(name);
//        System.out.println("添加融资情报:"+finance.toString());
        financeService.add(finance);
        return new Result(true, StatusCode.OK, "申请成功");
    }
    //添加组合贷款
    @ApiOperation(value = "添加组合贷款")
    @PostMapping("/addFinanceMulti")
    public Result addFinanceMulti(@RequestBody Finance finance) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        finance.setOwnName(name);
//        System.out.println(name);
        financeService.addMulti(finance);
        return new Result(true, StatusCode.OK, "申请成功");
    }

    //查询融资情况
    @ApiOperation(value = "查询融资情况")
    @GetMapping("/selectByName")
    public Result selectByName() {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();

        Finance finance = new Finance();
        finance.setOwnName(name);

        List<Finance> finances = financeService.selectByFinance(finance);

        return new Result(true, StatusCode.OK, "查询成功", finances);
    }

    //根据id修改融资情报
    @ApiOperation(value = "根据id修改融资情报")
    @PutMapping("/update")
    public Result update(@RequestBody Finance finance) {
//        System.out.println(finance);
        financeService.updateByFinance(finance);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //根据id删除融资情报
    @ApiOperation(value = "根据id删除融资情报")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        financeService.deleteByFinanceId(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //根据id查询融资情报
    @ApiOperation(value = "根据id查询融资情报")
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        Finance finance = financeService.selectByFinanceId(id);

        return new Result(true, StatusCode.OK, "查询成功", finance);
    }

    //查询银行情报
    @ApiOperation(value = "查询银行情报")
    @GetMapping("/selectbank")
    public Result selectbank() {
        List<Bank> banks = bankService.selectAllBank();
        return new Result(true, StatusCode.OK, "查询成功", banks);

    }
}
