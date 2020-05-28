package com.thienchidh.apithitracnghiem.adapter;

import com.thienchidh.apithitracnghiem.model.entities.BaiThi;
import com.thienchidh.apithitracnghiem.model.responses.Exam;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExamAdapter {

    public final SimpleDateFormat formatDateServer = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @NotNull
    public Exam convert(@NotNull BaiThi baiThi) {
        return Exam.builder()
                .maLoaiKt(baiThi.getMaBaiThi())
                .tenBaiThi(baiThi.getTenBaiThi())
                .lop(baiThi.getLop())
                .thoiGianBatDau(formatDateServer.format(baiThi.getThoiGianBatDau()))
                .baoLau(baiThi.getBaoLau())
                .thoiGianKetThuc(formatDateServer.format(baiThi.getThoiGianKetThuc()))
                .status(baiThi.getStatus().toString())
                .timeserver(formatDateServer.format(new Date()))
                .build();
    }

    @NotNull
    public List<Exam> convert(@NotNull List<BaiThi> list) {
        List<Exam> exams = new ArrayList<>();
        for (var e : list) {
            exams.add(convert(e));
        }
        return exams;
    }

}


