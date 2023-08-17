package com.demo.service;

import com.demo.entity.Account;

import java.util.List;

public interface AccountService {
    Account findById(String username);

    List<Account> findAll();
}
