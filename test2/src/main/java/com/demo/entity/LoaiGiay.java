package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "loaigiay")
public class LoaiGiay {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ten;

    @JsonIgnore
    @OneToMany(mappedBy = "loaigiay",fetch = FetchType.EAGER)
    List<Product> products;
}
