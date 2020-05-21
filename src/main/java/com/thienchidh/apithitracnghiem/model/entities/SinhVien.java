package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "SinhVien")
public class SinhVien extends User {
    @Column(name = "lop", nullable = false)
    private String lop;

    @Column(name = "ngaySinh")
    private Date ngaySinh;
}
