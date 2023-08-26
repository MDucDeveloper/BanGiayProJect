package com.demo.DAO;

import com.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountDAO extends JpaRepository<Account,String> {
    @Query("select distinct ar.account from Authority ar where ar.chucvu.id in ('DIRE','STAF')")
    List<Account> getAdministrator();
}
