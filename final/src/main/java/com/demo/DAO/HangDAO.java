package com.demo.DAO;

import com.demo.entity.Hang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HangDAO extends JpaRepository<Hang,Long> {
}
