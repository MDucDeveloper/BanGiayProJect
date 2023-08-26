package com.demo.interceptor;

import com.demo.DAO.HangDAO;
import com.demo.DAO.KichCoDAO;
import com.demo.DAO.MauSacDAO;
import com.demo.DAO.ThuongHieuDAO;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GloballInterceptor implements HandlerInterceptor {
    @Autowired
    CategoryService categoryService;

    @Autowired
    KichCoDAO kichCoDAO;

    @Autowired
    HangDAO hangDAO;

    @Autowired
    MauSacDAO mauSacDAO;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("cates",categoryService.findAll());
        request.setAttribute("sizes",kichCoDAO.findAll());
        request.setAttribute("thuonghieus",hangDAO.findAll());
        request.setAttribute("mausacs",mauSacDAO.findAll());
    }
}
