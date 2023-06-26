package com.qst.crop.service.impl;

import com.qst.crop.dao.AddressDao;
import com.qst.crop.entity.Address;
import com.qst.crop.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public void add(Address address) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        address.setOwnName(name);
        if (address.getIsDefault()) {
            // 将别的默认路径清除
            setZero();
        }
        addressDao.insertSelective(address);
    }

    @Override
    public List<Address> selectByOwnName() {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String ownName = principal.getUsername();
        List<Address> addresses = addressDao.selectByExample(ownName);
        return addresses;
    }

    @Override
    public Address selectDefaultByOwnName() {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        String isDef = "1";
        Address address = addressDao.selectOneByExample(name,isDef);

        return address;
    }

    @Override
    public void defaultAddressInfoUpdate(Address address) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();

        address.setOwnName(name);
        if (address.getIsDefault()) {
            // 将别的默认路径清除
            setZero();
        }
        update(address);
    }

    @Override
    public void update(Address address) {
        addressDao.updateByPrimaryKey(address);
    }

    @Override
    public boolean delete(Integer id) {
        Address address = addressDao.selectByPrimaryKey(id);
        if (address.getIsDefault()){
            return false;
        }else {
            addressDao.deleteByPrimaryKey(id);
            return true;
        }
    }

    /**
     * 让所有的地址默认值设为0
     */
    public void setZero() {
        Address address = selectDefaultByOwnName();
        if (null != address)
        {
            address.setIsDefault(false);
            update(address);
        }
    }

}
