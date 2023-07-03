package com.qst.crop.service;

import com.github.pagehelper.PageInfo;
import com.qst.crop.entity.Expert;
import com.qst.crop.entity.Question;

import java.util.List;

public interface QuestionService {

    void delete(Integer id);

    void insert(Question record);

    Question selectById(Integer id);

    void updateById(Question record);

    List<Question> selectByQuestion(String type);

    PageInfo<Question> selectByKeys(String keys, Integer pageNum);
}
