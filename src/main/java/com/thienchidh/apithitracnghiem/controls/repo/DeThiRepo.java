package com.thienchidh.apithitracnghiem.controls.repo;

import com.thienchidh.apithitracnghiem.model.entities.BaiThi;
import com.thienchidh.apithitracnghiem.model.entities.DanhSachCauHoi;
import com.thienchidh.apithitracnghiem.model.entities.DeThi;
import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeThiRepo extends JpaRepository<DeThi, Long> {

    List<DeThi> findAllBySinhVien(SinhVien sinhVien);

    List<DeThi> findAllByBaiThi(BaiThi baiThi);

    List<DeThi> findAllByDanhSachCauHoi(DanhSachCauHoi danhSachCauHoi);

}
