package com.qst.crop.service;

import com.github.pagehelper.PageInfo;
import com.qst.crop.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {
    PageInfo<Knowledge> findPage(Integer pageNum);

    void add(Knowledge knowledge);

    void update(Knowledge knowledge,Integer id);

    void delete(Integer id);

    List<Knowledge> selectByUsername(String name);

    Knowledge selectById(Integer id);

    PageInfo<Knowledge> findPageByKeys(String keys, Integer pageNum);
}
