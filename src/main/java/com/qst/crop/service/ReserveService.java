package com.qst.crop.service;

import com.qst.crop.entity.Reserve;

import java.util.List;

public interface ReserveService {

    void delete(Integer id);

    void insert(Reserve record);

    Reserve selectById(Integer id);

    void updateById(Reserve record);

    List<Reserve> selectByReserve(String type);
}
