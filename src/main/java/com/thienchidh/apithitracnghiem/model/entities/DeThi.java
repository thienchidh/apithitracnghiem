package com.thienchidh.apithitracnghiem.model.entities;

import javax.persistence.*;

@Entity(name = "DeThi")
public class DeThi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "baiThi")
    private BaiThi baiThi;
}
