package com.demo.controller;

import com.demo.DAO.AccountDAO;
import com.demo.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SecurityController {
    @Autowired
    AccountDAO accountDAO;
//    @Autowired
//    private AuthenticationManager authenticationManager;
    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message","Vui long dang nhap lai");
        return "security/login";
    }

    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message","Dang nhap thanh cong");
        return "redirect:/home";
    }

    @RequestMapping("/security/login/error")
    public String loginError(Model model){
        model.addAttribute("message","Sai thong tin dang nhap");
        return "security/login";
    }

    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message","Khong co quyen truy xuat");
        return "security/login";
    }

    @RequestMapping("/security/logoff/success")
    public String logout(Model model){
        model.addAttribute("message","Ban da dang xuat thanh cong!");
        return "security/login";
    }

    @GetMapping("/signup/form")
    public String signup(Model model){
        return "security/signup";
    }

    @PostMapping("signup/post")
    public String dky(Model model, HttpServletRequest request, RedirectAttributes redirectAttributes){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        boolean error = false;
        if(username.equals("") || username.length() < 8){
            model.addAttribute("errorUsername","Username không được để trống và phải có ít nhất 8 kí tự!");
            error = true;
        }

        if(password.equals("") || password.length() < 8){
            model.addAttribute("errorPassword","Password không được để trống và phải có ít nhất 8 kí tự!");
            error = true;
        }

        if(!password.equals(repassword)){
            model.addAttribute("errorRepassword","Nhập lại mật khẩu không trùng khớp!");
            error = true;
        }

        List<Account> listAcc = accountDAO.findAll();
        for(Account accountList: listAcc){
            if(username.equals(accountList.getUsername())){
                model.addAttribute("errorUsername","Username đã tồn tại!");
                System.out.println("Bi trung user name");
                error = true;
            }
        }

        if(!error){
            Account account = new Account();
            account.setUsername(username);
            account.setPass(password);
            account.setFullname(username);

            accountDAO.save(account);

//            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
//            Authentication authentication = authenticationManager.authenticate(authToken);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/security/login/success";
        }else{
            model.addAttribute("valueUser",username);
            model.addAttribute("valuePass",password);
            model.addAttribute("valueRepass",repassword);
            return "security/signup";
        }
    }
}
