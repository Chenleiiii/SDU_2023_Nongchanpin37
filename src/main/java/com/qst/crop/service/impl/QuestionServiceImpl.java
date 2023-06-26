package com.qst.crop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.crop.dao.QuestionDao;
import com.qst.crop.entity.Expert;
import com.qst.crop.entity.Question;
import com.qst.crop.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionDao questionDao;

    //每页显示多条数据
    private  Integer pageSize = 30;

    @Override
    public Question selectById(Integer id) {

        Question question = questionDao.selectByPrimaryKey(id);

        return question;
    }

    @Override
    public List<Question> selectByQuestion(String type) {

        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        Question question = new Question();
        if ("questioner".equals(type)){
            question.setQuestioner(name);
        } else {
            question.setExpertName(name);
        }
        List<Question> questions = questionDao.selectByQuestion(question);
        return questions;
    }

    @Override
    public void delete(Integer id) {
        questionDao.deleteByPrimaryKey(id);
    }
    @Override
    public void insert(Question question) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = principal.getUsername();
        question.setQuestioner(name);
        questionDao.insertSelective(question);
    }
    @Override
    public void updateById(Question question) {
        questionDao.updateByPrimaryKeySelective(question);
    }

    @Override
    public PageInfo<Question> selectByKeys(String keys, Integer pageNum){
        PageHelper.startPage(pageNum, pageSize);
        List<Question> questions = questionDao.selectAllByKeys(keys);
        PageInfo<Question> questionPageInfo = new PageInfo<>(questions);
        return questionPageInfo;
    }
}
