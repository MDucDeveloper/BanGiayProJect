package com.demo.DAO;

import com.demo.entity.Account;
import com.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorityDAO extends JpaRepository<Authority,Long> {
    @Query("select distinct a from Authority a where a.account in ?1")
    List<Authority> findAuthoritiesOfAdministrator(List<Account> accounts);
}
