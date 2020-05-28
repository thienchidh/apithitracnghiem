package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.controls.repo.BaiThiRepo;
import com.thienchidh.apithitracnghiem.model.entities.BaiThi;
import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import com.thienchidh.apithitracnghiem.model.responses.ExamQuestions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BaiThiManager {

    private BaiThiRepo baiThiRepo;

    public ExamQuestions getDiemBaiThi(SinhVien sinhVienServer, String maBaiThi) {
        Optional<BaiThi> byMaBaiThi = baiThiRepo.findByMaBaiThi(maBaiThi);
        if (byMaBaiThi.isPresent()) {
            String lop = sinhVienServer.getLop();


        }
        return null;
    }
}
