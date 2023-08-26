package com.qst.crop.service;

import com.qst.crop.entity.Discuss;

import java.util.List;

public interface DiscussService {

    void add(Discuss discuss);

    List<Discuss> selectByKnowledgeId(Integer knowledgeId);

}
