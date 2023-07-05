package com.qst.crop.dao;

import com.qst.crop.entity.Expert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExpertDao {
    List<Expert> selectExpertByKeys(@Param("keys") String keys);
}
