package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.entity.Reserve;
import com.qst.crop.service.ReserveService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author QST
 * @Description 预约模块
 * @Date 2021-08-24
 */
@Api(tags = "预约模块接口")
@RestController
@RequestMapping("/reserve")
@CrossOrigin
public class ReserveController {
    @Autowired
    private ReserveService reserveService;

    //根据ID查询预约情况
    @ApiOperation(value = "根据ID查询预约情况")
    @GetMapping("/selectId/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        Reserve reserve = reserveService.selectById(id);
        return new Result(true, StatusCode.OK, "查询成功", reserve);
    }

    //添加预约情报
    @ApiOperation(value = "添加预约情报")
    @PostMapping("/add")
    public Result add(@RequestBody Reserve reserve, BindingResult bindingResult) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        reserve.setQuestioner(name);
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
        reserveService.insert(reserve);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    //根据id修改预约情报
    @ApiOperation(value = "根据id修改预约情报")
    @PutMapping("/update")
    public Result update(@RequestBody Reserve reserve, BindingResult bindingResult) {

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
        reserveService.updateById(reserve);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //根据id删除预约情报
    @ApiOperation(value = "根据id删除预约情报")
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        reserveService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //根据用户查询预约情况
    @ApiOperation(value = "根据用户查询预约情况")
    @GetMapping("/selectByKind/{kind}")
    public Result selectByKind(@PathVariable("kind") String kind) {
        List<Reserve> reserves = reserveService.selectByReserve(kind);
        return new Result(true, StatusCode.OK, "查询成功", reserves);
    }
}
