package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "Favorite")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "sinhVien")
    @OneToOne
    private SinhVien sinhVien;

    @JoinColumn(name = "cauHoi")
    @OneToOne
    private CauHoi cauHoi;

}
