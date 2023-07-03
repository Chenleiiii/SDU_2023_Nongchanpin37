package com.qst.crop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.crop.dao.KnowledgeDao;
import com.qst.crop.entity.Knowledge;
import com.qst.crop.service.KnowledgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    //每页显示多条数据
    private static final Integer pageSize = 30;
    @Autowired
    private KnowledgeDao knowledgeDao;

    @Override
    public PageInfo<Knowledge> findPage(Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<Knowledge> knowledges = knowledgeDao.selectAll();
        PageInfo<Knowledge> knowledgePageInfo = new PageInfo<>(knowledges);
        return knowledgePageInfo;
    }

    @Override
    public void add(Knowledge knowledge) {
        //获取登陆的用户名
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        knowledge.setOwnName(name);
        knowledge.setCreateTime(new Date());
        knowledge.setUpdateTime(new Date());
        knowledgeDao.insertSelective(knowledge);
    }

    @Override
    public void update(Knowledge knowledge,Integer id) {
        knowledge.setKnowledgeId(id);
        knowledgeDao.updateByPrimaryKeySelective(knowledge);
    }

    @Override
    public void delete(Integer id) {
        knowledgeDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Knowledge> selectByUsername(String name) {
        List<Knowledge> knowledges = knowledgeDao.selectByExample(name);
        return knowledges;
    }

    @Override
    public Knowledge selectById(Integer id) {
        Knowledge knowledge = knowledgeDao.selectByPrimaryKey(id);
        return knowledge;
    }

    @Override
    public PageInfo<Knowledge> findPageByKeys(String keys, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<Knowledge> knowledges = knowledgeDao.selectAllByKeys(keys);
        PageInfo<Knowledge> knowledgePageInfo = new PageInfo<>(knowledges);
        return knowledgePageInfo;
    }
}
