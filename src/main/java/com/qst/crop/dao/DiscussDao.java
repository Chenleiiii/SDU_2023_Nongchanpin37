package com.qst.crop.dao;

import com.qst.crop.entity.Discuss;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface DiscussDao {

    int insert(Discuss record);

    List<Discuss> selectByKnowledgeId(@Param("knowledgeId") Integer knowledgeId);

}