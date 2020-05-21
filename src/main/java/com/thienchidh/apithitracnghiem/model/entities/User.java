package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "maSo", nullable = false, unique = true)
    private String maSo;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "ghiChu")
    private String ghiChu;
}
