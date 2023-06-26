package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.dao.OrderDao;
import com.qst.crop.dao.UserDao;
import com.qst.crop.entity.*;
import com.qst.crop.security.service.JwtUserDetailsServiceImpl;
import com.qst.crop.security.util.JwtTokenUtil;
import com.qst.crop.service.ExpertService;
import com.qst.crop.service.UserService;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * @author QST
 * @Description 用户模块
 * @Date 2021-08-24
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(tags = "用户模块接口")
public class UserController {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsServiceImpl jwtUserDetailsService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ExpertService expertService;
    //获取认证里面的用户信息,在每个方法里
//  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    //用户登录之后，修改用户密码
    @ApiOperation(value = "用户登录之后，修改用户密码")
    @PostMapping("/loginUpdatePassword")
    public Result<String> loginUpdatePassword(@Validated @RequestBody PasswordParam passwordParam, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage()).append("; ");
            }
            String s = stringBuffer.toString();
            System.out.println(s);
            return new Result<String>(false, StatusCode.ERROR, "密码修改失败", s);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String username = principal.getUsername();
        User user = userService.selectByUserName(username);
        //数据库密码
        String oldDataBasePassword = user.getPassword();
        //传过来的老密码
        String oldPassword = passwordParam.getOldPassword();
//        String encode = passwordEncoder.encode(oldPassword);

        if (!passwordEncoder.matches(oldPassword, oldDataBasePassword)) {
            return new Result<String>(false, StatusCode.ERROR, "原密码输入错误", "原密码输入错误");
        }
        user.setUserName(username);
        user.setPassword(passwordParam.getNewPassword());
        userService.update(user);
        return new Result<String>(true, StatusCode.OK, "修改成功");
    }

    //用户登录之后，根据用户名展示个人信息
    @ApiOperation(value = "用户登录之后，根据用户名展示个人信息")
    @GetMapping("/loginSelectByUsername")
    public Result<User> loginSelectByUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String username = principal.getUsername();
        User user = userService.selectByUserName(username);
        return new Result<User>(true, StatusCode.OK, "查询成功", user);
    }

    //用户登录之后，根据用户名修改个人基本信息
    @ApiOperation(value = "用户登录之后，根据用户名修改个人基本信息")
    @PostMapping("/loginUpdateByUsername")
    public Result<String> loginUpdateByUsername(@Validated @RequestBody User user, BindingResult bindingResult) {
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
            return new Result<String>(false, StatusCode.ERROR, "修改失败", errorInfo);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        String username = principal.getUsername();
        user.setUserName(username);
        userService.loginUpdateByUsername(user);
        UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtil.generateToken(userDetails);
        return new Result<String>(true, StatusCode.OK, "修改成功", token);
    }

    //查询所有用户
    @ApiOperation(value = "查询所有用户")
    @GetMapping
    public Result<List<User>> selectAll() {
        List<User> users = userService.selectAll();
        return new Result<List<User>>(true, StatusCode.OK, "查询成功", users);
    }

    //增加用户
    @ApiOperation(value = "增加用户")
    @PostMapping("/add")
    public Result<String> add(//@RequestParam(value = "file", required = false) MultipartFile file,
                              @Valid @RequestBody User user, BindingResult bindingResult
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            StringBuffer stringBuffer = new StringBuffer();
            for (ObjectError error : allErrors) {
                System.out.println(error);
                stringBuffer.append(error.getDefaultMessage()).append("; ");
            }
            System.out.println(stringBuffer);
            String errorInfo = stringBuffer.toString();
            return new Result<String>(false, StatusCode.ERROR, "注册失败", errorInfo);
        }
        String userName = user.getUserName();
        User user1 = userDao.selectByPrimaryKey(userName);
        if (user1!=null){
            return new Result<String>(false, StatusCode.ERROR, "注册失败", "用户名已被注册，请重新输入");
        }
        userService.add(user);
        return new Result(true, StatusCode.OK, "注册成功");
    }

    //修改用户
    @ApiOperation(value = "根据用户名修改用户信息")
    @PutMapping(value = "/{userName}")
    public Result<String> update(@Validated @RequestBody User user, BindingResult bindingResult, @PathVariable("userName") String userName) {
        if (bindingResult.hasErrors()) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                stringBuffer.append(objectError.getDefaultMessage()).append("; ");
            }
            String s = stringBuffer.toString();
            System.out.println(s);
            return new Result<String>(false, StatusCode.ERROR, "信息修改失败", s);
        }
        user.setUserName(userName);
        userService.update(user);
        return new Result<String>(true, StatusCode.OK, "信息修改成功", "修改成功");
    }

    //删除用户
    @ApiOperation(value = "根据用户名删除用户")
    @DeleteMapping("/{userName}")
    public Result<String> deletes(@PathVariable("userName") String userName) {
        //判断该用户是否有订单信息
        Order order = new Order();
        order.setOwnName(userName);
        List<Order> orders = orderDao.selectByExample(order);
        if (!orders.isEmpty()) {
            return new Result<String>(false, StatusCode.ERROR, "删除失败", "该用户有发布的订单，暂不能删除");
        }
        userService.delete(userName);
        expertService.delete(userName);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //根据用户名查询用户
    @ApiOperation(value = "根据用户名查询用户")
    @GetMapping("/{userName}")
    public Result selectByUserName(@PathVariable("userName") String userName) {
        User user = userService.selectByUserName(userName);
        return new Result(true, StatusCode.OK, "查询成功", user);
    }

    //分页查询所有用户
    @ApiOperation("分页查询所有用户")
    @GetMapping("/search/{pageNum}")
    public Result<PageInfo> findPage(@PathVariable("pageNum") Integer pageNum) {
        PageInfo<User> pageInfo = userService.findPage(pageNum);
        return new Result<PageInfo>(true, StatusCode.OK, "分页查询成功", pageInfo);
    }

    //分页条件查询
    @ApiOperation("分页条件查询用户")
    @PostMapping("/search/{pageNum}/{pageSize}")
    public Result<PageInfo> findPage(@RequestBody User user,
                                     @PathVariable("pageNum") Integer pageNum,
                                     @PathVariable("pageSize") Integer pageSize) {
        PageInfo<User> pageInfo = userService.findPage(user, pageNum, pageSize);
        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);
    }


    @ApiOperation("查询专家详情")
    @GetMapping("/searchexpert")
    public Result searchExpert() {

        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();

        Expert expert = expertService.selectById(name);

        return new Result(true, StatusCode.OK, "查询成功", expert);
    }

    @ApiOperation("查询所有专家详情")
    @GetMapping("/searchallexpert")
    public Result searchAllExpert() {

        List<Expert> experts = expertService.selectAllExpert();

        return new Result(true, StatusCode.OK, "查询成功", experts);
    }

    @ApiOperation("删除专家详情")
    @DeleteMapping("/deleteexpert/{userName}")
    public Result deleteExpert(@PathVariable("userName") String userName) {

        expertService.delete(userName);

        return new Result(true, StatusCode.OK, "删除成功");
    }

    @ApiOperation("更新专家详情")
    @PutMapping("/updateexpert")
    public Result updateExpert(@RequestBody Expert expert) {

        expertService.updateById(expert);

        return new Result(true, StatusCode.OK, "更新成功");
    }
    @ApiOperation("增加专家详情")
    @PostMapping("/addexpert")
    public Result addExpert(@RequestBody Expert expert) {

        expertService.insert(expert);

        return new Result(true, StatusCode.OK, "增加成功");
    }

    @ApiOperation("增加或修改专家详情")
    @PostMapping("/addUpdexpert")
    public Result addUpdexpert(@RequestBody Expert expert) {

        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        Expert expertExist = expertService.selectById(name);

        //设置专家用户名
        expert.setUserName(name);
        //如果专家存在，则更新，否则添加
        if (null != expertExist){
            expertService.updateById(expert);
        }
        else {
            expertService.insert(expert);
        }
        return new Result(true, StatusCode.OK, "操作成功");
    }
}
