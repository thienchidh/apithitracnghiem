package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.adapter.BaiThiAdapter;
import com.thienchidh.apithitracnghiem.adapter.ExamAdapter;
import com.thienchidh.apithitracnghiem.controls.repo.BaiThiRepo;
import com.thienchidh.apithitracnghiem.controls.repo.SinhVienRepo;
import com.thienchidh.apithitracnghiem.model.entities.BaiThi;
import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import com.thienchidh.apithitracnghiem.model.responses.Exam;
import com.thienchidh.apithitracnghiem.model.responses.ExamQuestions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BaiThiManager {

    private BaiThiRepo baiThiRepo;
    private ExamAdapter examAdapter;
    private BaiThiAdapter baiThiAdapter;
    private SinhVienRepo sinhVienRepo;

    public ExamQuestions getDiemBaiThi(SinhVien sinhVienServer, String maBaiThi) {
        Optional<BaiThi> byMaBaiThi = baiThiRepo.findByMaBaiThi(maBaiThi);
        if (byMaBaiThi.isPresent()) {
            String lop = sinhVienServer.getLop();


        }
        return null;
    }


    public BaiThi generateBaiThi(Exam exam) {
        return baiThiRepo.save(baiThiAdapter.convert(exam));
    }
}
