package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.controls.repo.SinhVienRepo;
import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import com.thienchidh.apithitracnghiem.model.responses.ListClass;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassManager {
    private SinhVienRepo sinhVienRepo;

    public ListClass getListClass() {
        List<SinhVien> all = sinhVienRepo.findAll();

        ListClass result = new ListClass();
        result.setListData(all.parallelStream().map(SinhVien::getLop).distinct().collect(Collectors.toList()));
        result.setSize(result.getListData().size());

        return result;
    }


}
