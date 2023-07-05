package com.qst.crop.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.rongxiaotong.demo.commom.R;
import com.example.rongxiaotong.demo.entity.User;
import com.example.rongxiaotong.demo.service.UserService;
import com.example.rongxiaotong.demo.service.impl.JwtUserDetailsServiceImpl;
import com.example.rongxiaotong.demo.util.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Api(tags = "用户模块接口")  生成文档，暂时不用


@Api(tags = "用户模块接口") //swagger相关注解
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

   @Autowired
    UserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;

    @ApiOperation(value = "用户登录")//与@Api配合使用
    @Transactional
    @PostMapping("/login")
    public R<User> login(HttpServletRequest request, @RequestBody User user){
        //提交密码进行md5加密处理
        String password= user.getPassword();
        password= DigestUtils.md5DigestAsHex(password.getBytes());

        //根据用户名username查询数据库
        LambdaQueryWrapper<User> queryWrapper= new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
         user=userService.getOne(queryWrapper);

        //如果登陆失败
        if(user==null){
            return R.error("登录失败");

        }
        //密码比对
        if(!user.getPassword().equals(password)){
            return R.error("登录失败");

        }


        //登录成功，员工id存入session并返回结果
        request.getSession().setAttribute("user",user.getId());
        return R.success(user);

    }



    //用户登录之后，根据用户名修改个人基本信息
    @Transactional
    @ApiOperation(value = "用户登录之后，根据用户名修改个人基本信息")
    @PostMapping("/loginUpdateByUsername")
    public R<String> loginUpdateByUsername(@Validated @RequestBody User user, BindingResult bindingResult) {
//        System.out.println(user);
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError error : allErrors) {
                System.out.println(error);
                stringBuffer.append(error.getDefaultMessage()).append("; ");
            }
            System.out.println(stringBuffer);
            String errorInfo = stringBuffer.toString();
            return  R.error("失败");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String username = principal.getUsername();
        user.setUsername(username);
        userService.updateById(user);
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        return  R.Result(1,"成功",token);
    }





}
