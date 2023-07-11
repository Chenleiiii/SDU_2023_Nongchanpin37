package com.qst.crop.dao;

import com.qst.crop.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public interface AddressDao{
    int insert(Address address);

    List<Address> selectByOwnName(@Param("name")String name);

    Address selectDefaultByOwnName(String name,String isDef);

    int updateById(Address address);

    Address selectById(Integer id);

    int deleteById(Integer id);
}
