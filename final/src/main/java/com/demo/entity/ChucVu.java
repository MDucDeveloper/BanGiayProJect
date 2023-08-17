package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chucvu")
public class ChucVu implements Serializable {
    @Id String id;
    String ten;

    @JsonIgnore
    @OneToMany(mappedBy = "chucvu",fetch = FetchType.EAGER)
    List<Authority> authorities;
}
