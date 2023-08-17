package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ten;
    String mota;
    Double gia;
    Integer soluong;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date ngaycapnhap;
    String image;

    @ManyToOne @JoinColumn(name = "id_loaigiay")
    LoaiGiay loaigiay;

    @ManyToOne @JoinColumn(name = "id_hang")
    Hang hang;

    @ManyToOne @JoinColumn(name = "id_kichco")
    KichCo kichco;

    @ManyToOne @JoinColumn(name = "id_mausac")
    MauSac mausac;

    @ManyToOne @JoinColumn(name = "id_chatlieu")
    ChatLieu chatlieu;

    @ManyToOne @JoinColumn(name = "id_thuonghieu")
    ThuongHieu thuonghieu;

    @ManyToOne @JoinColumn(name = "id_xuatxu")
    XuatXu xuatxu;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    List<OrderDetail> orderDetails;

}
