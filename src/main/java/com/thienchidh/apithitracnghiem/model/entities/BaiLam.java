package com.thienchidh.apithitracnghiem.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "BaiLam")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BaiLam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "deThi")
    @NonNull
    private DeThi deThi;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "danhSachDapAnSinhVien")
    private List<DapAn> listDapAn;

    @Builder.Default
    @NonNull
    private Mode currentState = Mode.AUTO_SAVE;

    public enum Mode {
        AUTO_SAVE,
        SUBMITTED
    }
}
