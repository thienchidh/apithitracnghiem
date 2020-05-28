package com.thienchidh.apithitracnghiem.controls.repo;

import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SinhVienRepo extends JpaRepository<SinhVien, Long> {
    Optional<SinhVien> findByMaSo(String maSo);

    List<SinhVien> findAllByMaSo(String maSo);

    List<SinhVien> findAllByLop(String lop);
}
