package com.qst.crop.service.impl;

import com.qst.crop.dao.AddressDao;
import com.qst.crop.dao.UserDao;
import com.qst.crop.entity.Address;
import com.qst.crop.entity.User;
import com.qst.crop.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AddressDao addressDao;
    //每页显示多条数据
    private  Integer pageSize = 30;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public void add(User user) {
//        加个默认地址
//        String userName = user.getUserName();
//        Address address = new Address();
//        address.setOwnName(userName);
//        address.setId(1);
//        address.setIsDefault(true);
//        address.setConsignee("请输入收货人姓名...");
//        address.setPhone("请输入收货人手机号...");
//        address.setAddressDetail("请输入收货人详细地址信息...");
//        addressDao.insertSelective(address);
        String password = user.getPassword();
        String encodePassword = passwordEncoder.encode(password);
        user.setPassword(encodePassword);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userDao.insertSelective(user);
    }

    @Override
    public void update(User user) {
        String password = user.getPassword();
        if (password!=null){
            String encode = passwordEncoder.encode(password);
            user.setPassword(encode);
        }
        user.setUpdateTime(new Date());
        userDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public void delete(String userName) {
        userDao.deleteByPrimaryKey(userName);
    }

    @Override
    public User selectByUserName(String userName) {
        User user = userDao.selectByPrimaryKey(userName);
//        System.out.println("====================================loadUserByUsername访问了数据库===================================");
        return user;
    }

    @Override
    public PageInfo<User> findPage(Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectAll();
        PageInfo<User> userPageInfo = new PageInfo<User>(users);
        return userPageInfo;
    }

    @Override
    public PageInfo<User> findPage(User user, Integer pageNum, Integer pageSize) {
        //TODO
//        Example example = createExample(user);
//        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userDao.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    @Override
    public void loginUpdateByUsername(User user) {
        user.setUpdateTime(new Date());
        userDao.updateByPrimaryKeySelective(user);
    }

    //创建example
    public Example createExample(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(user.getUserName())) {
            criteria.andLike("userName", "%" + user.getUserName() + "%");
        }
        if (!StringUtils.isEmpty(user.getAddress())){
            criteria.andLike("address", "%" + user.getAddress() + "%");
        }
        return example;
    }
}
