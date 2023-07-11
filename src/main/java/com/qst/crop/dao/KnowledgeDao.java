package com.qst.crop.dao;

import com.qst.crop.entity.Knowledge;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface KnowledgeDao{

    List<Knowledge> selectAll();

    int insert(Knowledge knowledge);

    int updateById(Knowledge knowledge);

    int deleteById(Integer id);

    List<Knowledge> selectByName(@Param("name")String name);

    Knowledge selectById(Integer id);

    List<Knowledge> selectKnowledgeByKeys(@Param("keys")String keys);

}
