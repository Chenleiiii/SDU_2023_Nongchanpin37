package com.qst.crop.dao;

import com.qst.crop.entity.Reserve;
import java.util.List;

public interface ReserveDao {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Reserve record);

    Reserve selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reserve record);

    List<Reserve> selectByReserve(Reserve record);
}