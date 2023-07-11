package com.qst.crop.dao;

import com.qst.crop.entity.Reserve;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface ReserveDao {

    int delete(Integer id);

    int insert(Reserve record);

    Reserve selectById(Integer id);

    int update(Reserve record);

    List<Reserve> selectByReserve(Reserve record);
}