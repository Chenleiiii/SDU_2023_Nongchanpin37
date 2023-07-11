package com.qst.crop.dao;

import com.qst.crop.entity.Expert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface ExpertDao {
    List<Expert> selectExpertByKeys(@Param("keys") String keys);

    int deleteByName(String userName);

    Expert selectByName(String userName);

    List<Expert> selectAllExpert();

    int updateByName(Expert record);

    int insert(Expert record);




}
