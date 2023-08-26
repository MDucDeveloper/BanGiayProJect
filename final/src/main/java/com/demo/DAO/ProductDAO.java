package com.demo.DAO;

import com.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.loaigiay.id = ?1")
    List<Product> findbyCategoryId(Long cid);

    @Query("select p from Product p where " +
            "(p.gia is null or (p.gia between ?1 and ?2)) and " +
            "(p.hang.id = ?3 or ?3 is null) and " +
            "(p.kichco.id = ?4 or ?4 is null) and " +
            "(p.mausac.id = ?5 or ?5 is null)")
    List<Product> findByReferences(Double priceFrom, Double priceTo, Long idbrand, Long idsize, Long idcolor);

    @Query("select p from Product p where " +
            "(p.hang.id = ?1 or ?1 is null) and " +
            "(p.kichco.id = ?2 or ?2 is null) and " +
            "(p.mausac.id = ?3 or ?3 is null)")
    List<Product> findThreeReferences(Long idbrand, Long idsize, Long idcolor);
}
