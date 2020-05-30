package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
    @NonNull
    @Column(name = "maBaiThi", nullable = false, unique = false)
    private String maBaiThi;

    @NonNull
    @Column(name = "tenBaiThi", nullable = false, unique = false)
    private String tenBaiThi;

    @NonNull
    @Column(name = "thoiGianBatDau", nullable = false)
    private Date thoiGianBatDau;

    @Column(name = "baoLau", nullable = false)
    private long baoLau;

    @NonNull
    @Column(name = "thoiGianKetThuc", nullable = false)
    private Date thoiGianKetThuc;

    @NonNull
    @Column(name = "lop", nullable = false)
    private String lop;

    @NonNull
    @Column(name = "status", nullable = false)
    private Status status;

    public enum Status {
        NOT_STARTED,
        PENDING,
        FINISHED,
        DISABLED
    }
}
