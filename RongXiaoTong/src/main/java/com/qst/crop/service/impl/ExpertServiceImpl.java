package com.qst.crop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.crop.dao.ExpertDao;
import com.qst.crop.entity.Expert;
import com.qst.crop.entity.Order;
import com.qst.crop.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertServiceImpl implements ExpertService {
    @Autowired
    private ExpertDao expertDao;

    //每页显示多条数据
    private  Integer pageSize = 30;

    @Override
    public Expert selectById(String name) {

        Expert expert = expertDao.selectByPrimaryKey(name);

        return expert;
    }

    @Override
    public List<Expert> selectAllExpert() {

        List<Expert> experts = expertDao.selectAllExpert();

        return experts;
    }

    @Override
    public void delete(String name) {
        expertDao.deleteByPrimaryKey(name);
    }

    @Override
    public void insert(Expert expert) {
        expertDao.insertSelective(expert);
    }

    @Override
    public void updateById(Expert expert) {
        expertDao.updateByPrimaryKeySelective(expert);
    }

    @Override
    public PageInfo<Expert> findPage(Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        List<Expert> experts = expertDao.selectAllExpert();
        PageInfo<Expert> expertPageInfo = new PageInfo<>(experts);
        return expertPageInfo;
    }

    @Override
    public PageInfo<Expert> findPageByKeys(String keys, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        List<Expert> experts = expertDao.selectAllByKeys(keys);
        PageInfo<Expert> orderPageInfo = new PageInfo<>(experts);
        return orderPageInfo;
    }
}
