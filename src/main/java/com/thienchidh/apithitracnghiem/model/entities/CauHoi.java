package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "CauHoi")
public class CauHoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "dapAnA")
    private String dapAnA;

    @Column(name = "dapAnB")
    private String dapAnB;

    @Column(name = "dapAnC")
    private String dapAnC;

    @Column(name = "dapAnD")
    private String dapAnD;

    @Column(name = "dapAnE")
    private String dapAnE;

    @Column(name = "dapAnF")
    private String dapAnF;

    @Column(name = "dapAnDung")
    private String dapAnDung;// a|b|c|d

    @Column(name = "rate")
    private int rate;

    @Column(name = "thuoc_chuong")
    private String thuocChuong;
}
