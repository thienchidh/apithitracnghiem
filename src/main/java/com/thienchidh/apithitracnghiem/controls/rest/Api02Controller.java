package com.thienchidh.apithitracnghiem.controls.rest;

import com.thienchidh.apithitracnghiem.controls.repo.SinhVienRepo;
import com.thienchidh.apithitracnghiem.controls.service.AccountManager;
import com.thienchidh.apithitracnghiem.controls.service.BaiThiManager;
import com.thienchidh.apithitracnghiem.controls.service.DeThiManager;
import com.thienchidh.apithitracnghiem.model.entities.BaiThi;
import com.thienchidh.apithitracnghiem.model.entities.DanhSachCauHoi;
import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import com.thienchidh.apithitracnghiem.model.responses.ExamSchedule;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/apiThitracnghiem/api02/GiangVien")
public class Api02Controller {

    private DeThiManager deThiManager;
    private BaiThiManager baiThiManager;
    private AccountManager accountManager;

    private SinhVienRepo sinhVienRepo;


    @PostMapping("/postLichThi_Lop_BaiThi")
    public ResponseEntity<?> postLichThi_Lop_BaiThi(@RequestBody ExamSchedule examSchedule) {
        if (accountManager.isAccountValid(examSchedule.getAccount())) {
            BaiThi baiThi = baiThiManager.generateBaiThi(examSchedule.getExam());

            List<DanhSachCauHoi> listDSCauHoi = new ArrayList<>();
            for (int i = 0; i < 5; ++i) {
                DanhSachCauHoi danhSachCauHoi = deThiManager.generateDanhSachCauHoi();
                listDSCauHoi.add(danhSachCauHoi);
            }


            List<SinhVien> allByLop = sinhVienRepo.findAllByLop(baiThi.getLop());
            for (int i = 0, indexDsCauHoi = i; i < allByLop.size(); i++, indexDsCauHoi = i % listDSCauHoi.size()) {
                SinhVien sinhVien = allByLop.get(i);
                DanhSachCauHoi danhSachCauHoi = listDSCauHoi.get(indexDsCauHoi);
                deThiManager.generateDeThi(baiThi, danhSachCauHoi, sinhVien);
            }

            HashMap<Object, Object> body = new HashMap<>();
            body.put("status", "success");
            return ResponseEntity.ok(body);
        }
        return ResponseEntity.notFound().build();
    }

}
