package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "DapAn")
public class DapAn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @JoinColumn(name = "cauHoi")
    @ManyToOne
    private CauHoi cauHoi;

    @Column(name = "dapAn")
    private String dapAn;// a | b | c | d
}
