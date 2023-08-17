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
@Table(name = "thuonghieu")
public class ThuongHieu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ten;

    @JsonIgnore
    @OneToMany(mappedBy = "thuonghieu",fetch = FetchType.EAGER)
    List<Product> products;
}
