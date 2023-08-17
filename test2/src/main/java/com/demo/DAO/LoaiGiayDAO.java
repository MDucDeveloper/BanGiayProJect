package com.demo.DAO;

import com.demo.entity.LoaiGiay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaiGiayDAO extends JpaRepository<LoaiGiay,Long> {
}
