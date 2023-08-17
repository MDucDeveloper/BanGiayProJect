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
@Table(name = "kichco")
public class KichCo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer giatri;

    @JsonIgnore
    @OneToMany(mappedBy = "kichco",fetch = FetchType.EAGER)
    List<Product> products;
}
