package com.demo.DAO;

import com.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.loaigiay.id = ?1")
    List<Product> findbyCategoryId(Long cid);
}
