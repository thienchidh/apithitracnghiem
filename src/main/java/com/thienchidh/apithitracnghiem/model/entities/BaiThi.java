package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "BaiThi")
public class BaiThi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * example: GK_001
     */
    @Column(name = "maBaiThi", nullable = false, unique = false)
    private String maBaiThi;

    @Column(name = "tenBaiThi", nullable = false, unique = false)
    private String tenBaiThi;

    @Column(name = "thoiGianBatDau", nullable = false)
    private Date thoiGianBatDau;

    @Column(name = "baoLau", nullable = false)
    private long baoLau;

    @Column(name = "lop", nullable = false)
    private String lop;

    @Column(name = "status", nullable = false)
    private Status status;

    public enum Status {
        NOT_STARTED,
        PENDING,
        FINISHED,
    }
}
