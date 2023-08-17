package com.demo.service.impl;

import com.demo.DAO.LoaiGiayDAO;
import com.demo.entity.LoaiGiay;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    LoaiGiayDAO loaiGiayDAO;
    @Override
    public List<LoaiGiay> findAll() {
        return loaiGiayDAO.findAll();
    }
}
