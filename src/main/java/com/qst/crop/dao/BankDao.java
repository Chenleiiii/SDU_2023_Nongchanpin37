package com.qst.crop.dao;

import com.qst.crop.entity.Bank;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Component
@Repository
public interface BankDao {

    List<Bank> selectAllBank();

}