package com.thienchidh.apithitracnghiem.adapter;

import com.thienchidh.apithitracnghiem.model.entities.BaiThi;
import com.thienchidh.apithitracnghiem.model.responses.Exam;
import lombok.SneakyThrows;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BaiThiAdapter {

    public final SimpleDateFormat formatDateClient = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @SneakyThrows
    @NotNull
    public BaiThi convert(@NotNull Exam exam) {
        BaiThi baiThi = new BaiThi();
        String maLoaiKt = exam.getMaLoaiKt();
        if (maLoaiKt == null) {
            maLoaiKt = exam.getTenBaiThi().substring(0, 3) + new SecureRandom().nextDouble() * 10;
        }
        baiThi.setMaBaiThi(maLoaiKt);
        baiThi.setTenBaiThi(exam.getTenBaiThi());
        baiThi.setThoiGianBatDau(formatDateClient.parse(exam.getThoiGianBatDau()));
        baiThi.setBaoLau(exam.getBaoLau());
        baiThi.setThoiGianKetThuc(computeThoiGianKetThuc(exam));
        baiThi.setLop(exam.getLop());
        baiThi.setStatus(computeStatus(exam));

        return baiThi;
    }

    @SneakyThrows
    private Date computeThoiGianKetThuc(Exam baiThi) {
        Date thoiGianKetThuc;
        try {
            thoiGianKetThuc = formatDateClient.parse(baiThi.getThoiGianKetThuc());
        } catch (ParseException e) {
            var thoiGianBatDau = formatDateClient.parse(baiThi.getThoiGianBatDau());
            var baoLau = baiThi.getBaoLau();

            Calendar instance = Calendar.getInstance();
            instance.setTime(thoiGianBatDau);
            instance.add(Calendar.MINUTE, (int) baoLau);

            thoiGianKetThuc = instance.getTime();
        }

        return thoiGianKetThuc;
    }

    @SneakyThrows
    private BaiThi.Status computeStatus(Exam baiThi) {
        Date parse = formatDateClient.parse(baiThi.getThoiGianKetThuc());
        if (new Date().after(parse)) {
            return BaiThi.Status.FINISHED;
        }

        if (new Date().before(parse)) {
            return BaiThi.Status.NOT_STARTED;
        }
        return BaiThi.Status.PENDING;
    }

    @NotNull
    public List<BaiThi> convert(@NotNull List<Exam> list) {
        List<BaiThi> exams = new ArrayList<>();
        for (var e : list) {
            exams.add(convert(e));
        }
        return exams;
    }

}


