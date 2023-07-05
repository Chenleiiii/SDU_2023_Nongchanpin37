package com.qst.crop.dao;

import com.qst.crop.entity.Knowledge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface KnowledgeDao{

    List<Knowledge> selectAll();

    int insertSelective(Knowledge knowledge);

    int updateByPrimaryKeySelective(Knowledge knowledge);

    int deleteByPrimaryKey(Integer id);

    List<Knowledge> selectByExample(@Param("name")String name);

    Knowledge selectByPrimaryKey(Integer id);

    List<Knowledge> selectAllByKeys(@Param("keys")String keys);

}
