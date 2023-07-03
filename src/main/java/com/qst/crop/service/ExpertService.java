package com.qst.crop.service;

import com.github.pagehelper.PageInfo;
import com.qst.crop.entity.Expert;
import com.qst.crop.entity.Order;

import java.util.List;

public interface ExpertService {

    void delete(String type);

    void insert(Expert record);

    Expert selectById(String type);

    void updateById(Expert record);

    List<Expert> selectAllExpert();

    PageInfo<Expert> findPage(Integer pageNum);

    PageInfo<Expert> findPageByKeys(String keys, Integer pageNum);

}
