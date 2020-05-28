package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.controls.repo.BaiThiRepo;
import com.thienchidh.apithitracnghiem.controls.repo.CauHoiRepo;
import com.thienchidh.apithitracnghiem.controls.repo.FavoriteRepo;
import com.thienchidh.apithitracnghiem.model.responses.Exam;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExamManager {
    private CauHoiRepo cauHoiRepo;
    private FavoriteRepo favoriteRepo;
    private BaiThiRepo baiThiRepo;

    public boolean createExam(Exam examClient) {
        String tenBaiThi = examClient.getTenBaiThi();
        String thoiGianBatDau = examClient.getThoiGianBatDau();
        long baoLau = examClient.getBaoLau();


        // TODO: 27/05/2020
        throw new RuntimeException("Not implemented!");
    }


}
