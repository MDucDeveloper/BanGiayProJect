package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoadonchitiet")
public class OrderDetail implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer soluong;
    Integer giaban;
    @ManyToOne
    @JoinColumn(name = "id_sanpham")
    Product product;
    @ManyToOne
    @JoinColumn(name = "id_donhang")
    Order order;
}
