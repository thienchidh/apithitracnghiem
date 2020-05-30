package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.controls.repo.CauHoiRepo;
import com.thienchidh.apithitracnghiem.controls.repo.DanhSachCauHoiRepo;
import com.thienchidh.apithitracnghiem.controls.repo.DeThiRepo;
import com.thienchidh.apithitracnghiem.model.entities.*;
import lombok.AllArgsConstructor;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class DeThiManager {

    public static final int LIMIT_NUM_QUESTIONS = 40;

    private DeThiRepo deThiRepo;
    private DanhSachCauHoiRepo danhSachCauHoiRepo;
    private CauHoiRepo cauHoiRepo;
    private Random random;

    @NotNull
    public DeThi generateDeThi(@NotNull BaiThi baiThiServer,
                               @NotNull DanhSachCauHoi danhSachCauHoiServer,
                               @NotNull SinhVien sinhVienServer) {

        DeThi entity = new DeThi();
        entity.setBaiThi(baiThiServer);
        entity.setDanhSachCauHoi(danhSachCauHoiServer);
        entity.setSinhVien(sinhVienServer);

        return deThiRepo.save(entity);
    }

    @NotNull
    public DanhSachCauHoi generateDanhSachCauHoi() {
        DanhSachCauHoi cauHoi = new DanhSachCauHoi();
        cauHoi.setCauHois(generateCauHoi(LIMIT_NUM_QUESTIONS));

        return danhSachCauHoiRepo.save(cauHoi);
    }

    @NotNull
    private List<CauHoi> generateCauHoi(int limitSize) {
        List<CauHoi> all = cauHoiRepo.findAll();

        int left = random.nextInt(all.size());
        int right = left + limitSize - 1;

        List<CauHoi> randomList = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            int index = i % all.size();
            randomList.add(all.get(index));
        }


        for (int i = 0; i < 10; ++i) {
            int x = random.nextInt(randomList.size());
            int y = random.nextInt(randomList.size());
            // swap index x, y

            var tmp = randomList.get(y);
            randomList.set(x, randomList.get(y));
            randomList.set(y, tmp);


        }

        return randomList;
    }


    public DeThi getDeThi(SinhVien sinhVienServer, BaiThi baiThiServer) {

        List<DeThi> allBySinhVien = deThiRepo.findAllBySinhVien(sinhVienServer);
        for (DeThi deThi : allBySinhVien) {
            if (deThi.getBaiThi().getMaBaiThi().equals(baiThiServer.getMaBaiThi()) && deThi.getSinhVien().getMaSo().equals(sinhVienServer.getMaSo())) {
                return deThi;
            }
        }

        List<DeThi> allByBaiThi = deThiRepo.findAllByBaiThi(baiThiServer);
        for (DeThi deThi : allByBaiThi) {
            if (deThi.getBaiThi().getMaBaiThi().equals(baiThiServer.getMaBaiThi()) && deThi.getSinhVien().getMaSo().equals(sinhVienServer.getMaSo())) {
                return deThi;
            }
        }
        return null;
    }

}
