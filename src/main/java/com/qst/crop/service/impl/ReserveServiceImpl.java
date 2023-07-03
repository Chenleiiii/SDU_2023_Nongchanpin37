package com.qst.crop.service.impl;

import com.qst.crop.dao.ReserveDao;
import com.qst.crop.entity.Reserve;
import com.qst.crop.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveDao reserveDao;

    @Override
    public Reserve selectById(Integer id) {

        Reserve reserve = reserveDao.selectByPrimaryKey(id);

        return reserve;
    }

    @Override
    public List<Reserve> selectByReserve(String type) {

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        Reserve reserve = new Reserve();
        if ("questioner".equals(type)){
            reserve.setQuestioner(name);
        } else {
            reserve.setExpertName(name);
        }
        List<Reserve> reserves = reserveDao.selectByReserve(reserve);

        return reserves;
    }

    @Override
    public void delete(Integer id) {
        reserveDao.deleteByPrimaryKey(id);
    }

    @Override
    public void insert(Reserve reserve) {
        reserveDao.insertSelective(reserve);
    }

    @Override
    public void updateById(Reserve reserve) {
        reserveDao.updateByPrimaryKeySelective(reserve);
    }
}
