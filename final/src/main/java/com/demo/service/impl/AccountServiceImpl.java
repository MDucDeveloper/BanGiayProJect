package com.demo.service.impl;

import com.demo.DAO.AccountDAO;
import com.demo.entity.Account;
import com.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDAO adao;

    @Override
    public Account findById(String username) {
        return adao.findById(username).get();
    }

    @Override
    public List<Account> findAll() {
        return adao.findAll();
    }


}
