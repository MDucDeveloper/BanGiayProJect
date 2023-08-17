package com.demo.DAO;

import com.demo.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderDetailDAO extends JpaRepository<OrderDetail,Long> {
}
