package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "SinhVienBaiThi")
public class SinhVienBaiThi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn
    @OneToOne
    private SinhVien sinhVien;

    @JoinColumn
    @OneToOne
    private BaiThi baiThi;


}
