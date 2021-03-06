package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "DeThi")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeThi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "baiThi")
    private BaiThi baiThi;

    @ManyToOne
    @JoinColumn(name = "danhSachCauHoi")
    private DanhSachCauHoi danhSachCauHoi;

    @ManyToOne
    @JoinColumn(name = "sinhVien")
    private SinhVien sinhVien;
}
