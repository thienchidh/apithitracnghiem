package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "DanhSachCauHoi")
public class DanhSachCauHoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "cauhois")
    @ManyToMany(fetch = FetchType.EAGER)
    private List<CauHoi> cauHois;
}
