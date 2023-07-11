package com.qst.crop.dao;

import com.qst.crop.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface QuestionDao {
    List<Question> selectQuesByKeys(@Param("keys") String keys);

    Question selectById(Integer id);

    int insertQuestion(Question question);

    int updateQuestionById(Question question);

    List<Question> selectByMan(Question question);

    int deleteQuestionById(Integer id);





}
