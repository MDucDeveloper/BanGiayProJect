package com.demo.service;

import com.demo.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByCategoryId(Long cid);

    Product create(Product product);

    Product update(Product product);

    void delete(Long id);

    List<Product> findAllReferences(Double pricefrom, Double priceto, Long idbrand, Long idsize, Long idcolor);

    List<Product> find3References(Long idbrand, Long idsize, Long idcolor);
}
