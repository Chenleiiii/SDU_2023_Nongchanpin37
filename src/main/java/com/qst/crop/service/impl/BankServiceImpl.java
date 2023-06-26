package com.qst.crop.service.impl;

import com.qst.crop.dao.BankDao;
import com.qst.crop.entity.Bank;
import com.qst.crop.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    @Autowired
    private BankDao bankDao;

    @Override
    public List<Bank> selectAllBank() {

        List<Bank> banks = bankDao.selectAllBank();

        return banks;
    }

}
