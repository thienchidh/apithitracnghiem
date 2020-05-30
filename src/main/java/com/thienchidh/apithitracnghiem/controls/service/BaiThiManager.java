package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.adapter.BaiThiAdapter;
import com.thienchidh.apithitracnghiem.adapter.ExamAdapter;
import com.thienchidh.apithitracnghiem.controls.repo.BaiLamRepo;
import com.thienchidh.apithitracnghiem.controls.repo.BaiThiRepo;
import com.thienchidh.apithitracnghiem.controls.repo.SinhVienRepo;
import com.thienchidh.apithitracnghiem.model.entities.*;
import com.thienchidh.apithitracnghiem.model.responses.Exam;
import com.thienchidh.apithitracnghiem.model.responses.ExamQuestions;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class BaiThiManager {

    public static final double MAX_POINT = 10.0;
    private BaiThiRepo baiThiRepo;
    private BaiLamRepo baiLamRepo;
    private ExamAdapter examAdapter;
    private BaiThiAdapter baiThiAdapter;
    private SinhVienRepo sinhVienRepo;

    public ExamQuestions getDiemBaiThi(DeThi deThiServer) {

        class LocalStringHelper {
            String convertFromList(@NotNull List<String> list, @NotNull String concat) {
                StringBuilder rs = new StringBuilder();
                for (String element : list) {
                    rs.append(element).append(concat);
                }
                return rs.toString();
            }
        }

        ExamQuestions examQuestions = new ExamQuestions();

        Optional<BaiLam> byDeThi = baiLamRepo.findByDeThi(deThiServer);
        if (byDeThi.isPresent()) {

            SinhVien sinhVien = deThiServer.getSinhVien();
            BaiThi baiThi = deThiServer.getBaiThi();
            DanhSachCauHoi danhSachCauHoi = deThiServer.getDanhSachCauHoi();
            BaiLam baiLam = byDeThi.get();

            Map<String, List<String>> mapDapAn = new TreeMap<>();

            List<DapAn> listDapAn = baiLam.getListDapAn();
            for (DapAn dapAn : listDapAn) {
                String dapAnChar = dapAn.getDapAn();
                List<String> listIdQuestions = mapDapAn.getOrDefault(dapAnChar, new ArrayList<>());
                listIdQuestions.add(dapAn.getCauHoi().getId() + "");
                mapDapAn.put(dapAnChar, listIdQuestions);
            }

//            assert (mapDapAn.size() >= 4);

            examQuestions.setMssv(sinhVien.getMaSo());
            examQuestions.setHoTen(sinhVien.getHoTen());
            examQuestions.setBaiThi(baiThi.getMaBaiThi());
            examQuestions.setListCauHoi(danhSachCauHoi.getId() + "");
            examQuestions.setDapAnA(new LocalStringHelper().convertFromList(mapDapAn.get("A"), ";"));
            examQuestions.setDapAnB(new LocalStringHelper().convertFromList(mapDapAn.get("B"), ";"));
            examQuestions.setDapAnC(new LocalStringHelper().convertFromList(mapDapAn.get("C"), ";"));
            examQuestions.setDapAnD(new LocalStringHelper().convertFromList(mapDapAn.get("D"), ";"));
            examQuestions.setDapAnE(new LocalStringHelper().convertFromList(mapDapAn.get("E"), ";"));
            examQuestions.setDapAnF(new LocalStringHelper().convertFromList(mapDapAn.get("F"), ";"));


            List<CauHoi> cauHois = danhSachCauHoi.getCauHois();
            int totalQuestions = cauHois.size();
            int userAnswerCorrectCount = 0;

            for (CauHoi e : cauHois) {
                List<String> list = mapDapAn.get(e.getDapAnDung());
                if (list.contains(e.getId() + "")) {
                    ++userAnswerCorrectCount;
                }
            }

            double point = (userAnswerCorrectCount * MAX_POINT / totalQuestions);
            examQuestions.setDiem(point + "");

            examQuestions.setListCauHoiDetails(null);// TODO: 30/05/2020

            return examQuestions;
        }

        return null;
    }


    public BaiThi generateBaiThi(Exam exam) {
        return baiThiRepo.save(baiThiAdapter.convert(exam));
    }
}
