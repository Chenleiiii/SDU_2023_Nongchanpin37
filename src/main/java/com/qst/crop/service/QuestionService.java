package com.qst.crop.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.crop.dao.QuestionDao;
import com.qst.crop.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionDao questionMapper;

    //每页显示多条数据
    private Integer pageSize = 30;

    public PageInfo<Question> selectByKeys(String keys, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        List<Question> questions = questionMapper.selectQuesByKeys(keys);
        PageInfo<Question> questionPageInfo = new PageInfo<>(questions);
        return questionPageInfo;
    }

    public Question selectById(Integer id) {
        Question question = questionMapper.selectById(id);
        return question;
    }

    public void insert(Question question) {
        UserDetails userDetail = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = userDetail.getUsername();
        question.setQuestioner(name);
        questionMapper.insertQuestion(question);
    }

    public void update(Question question) {
        questionMapper.updateQuestionById(question);
    }

    public List<Question> selectByMan(String type) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        Question question = new Question();
        if ("questioner".equals(type)){
            question.setQuestioner(name);
        } else {
            question.setExpertName(name);
        }
        List<Question> questions = questionMapper.selectByMan(question);
        return questions;
    }

    public void delete(Integer id) {
        questionMapper.deleteQuestionById(id);
    }



}
