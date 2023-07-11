package com.qst.crop.dao;

import com.qst.crop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface UserDao {

    User selectByName(String userName);

    int insert(User user);

    int updateByName(User user);

    List<User> selectAll();

    int deleteByName(String userName);

    String selectAddressByName(String ownName);

}
