package com.demo.rest;

import com.demo.DAO.AccountDAO;
import com.demo.DAO.AuthorityDAO;
import com.demo.DAO.ChucVuDAO;
import com.demo.entity.Account;
import com.demo.entity.Authority;
import com.demo.entity.ChucVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
public class RolesRestController {
    @Autowired
    ChucVuDAO chucVuDAO;

    @Autowired
    AccountDAO accountDAO;

    @Autowired
    AuthorityDAO authorityDAO;

    @RequestMapping("/roles")
    public List<ChucVu> getRoles(){
        return chucVuDAO.findAll();
    }

    @RequestMapping("/accounts")
    public List<Account> getAccounts(@RequestParam("admin")Optional<Boolean> admin){
        if(admin.orElse(false)){
            return accountDAO.getAdministrator();
        }
        return accountDAO.findAll();
    }

    @RequestMapping("/authorities")
    public List<Authority> getAuthorities(@RequestParam("admin")Optional<Boolean> admin){
        if(admin.orElse(false)){
            List<Account> list = accountDAO.getAdministrator();
            list.stream().forEach(l-> System.out.println(l.getUsername()));
            List<Authority> list1 = authorityDAO.findAuthoritiesOfAdministrator(list);
            list1.stream().forEach(l-> System.out.println(l.getId()));
            return authorityDAO.findAuthoritiesOfAdministrator(list);
        }
        return authorityDAO.findAll();
    }

    @PostMapping("/authorities")
    public Authority post(@RequestBody Authority auth){
        return authorityDAO.save(auth);
    }

    @DeleteMapping("/authorities/{id}")
    public void delete(@PathVariable("id") Long id){
         authorityDAO.deleteById(id);
    }
}
