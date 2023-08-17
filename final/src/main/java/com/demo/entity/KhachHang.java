package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "khachhang")
public class KhachHang {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long makhachhang;
    String tenkhachhang;
    String sodienthoai;
    Integer gioitinh;

    @ManyToOne @JoinColumn(name = "hangkhachhang")
    HangKhachHang hangkhachhang;

}
