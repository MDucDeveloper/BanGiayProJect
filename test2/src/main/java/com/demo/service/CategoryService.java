package com.demo.service;

import com.demo.entity.LoaiGiay;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {
    List<LoaiGiay> findAll();
}
