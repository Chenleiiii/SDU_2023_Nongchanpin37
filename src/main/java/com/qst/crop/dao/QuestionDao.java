package com.qst.crop.dao;

import com.qst.crop.entity.Question;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface QuestionDao {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    List<Question> selectByQuestion(Question record);

    List<Question> selectAllByKeys(@Param("keys")String keys);

}